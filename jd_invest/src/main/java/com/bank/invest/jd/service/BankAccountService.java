package com.bank.invest.jd.service;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.invest.jd.mapper.BankAccountMapper;
import com.bank.invest.jd.vo.BankAccount;

@Service
public class BankAccountService {
	@Autowired private BankAccountMapper bankAccountMapper;
	
	public int bankAccountAdd(BankAccount bankAccount) {
		System.out.println("getMemberId : "+bankAccount.getMemberId());
		System.out.println("getAccountBranch : "+bankAccount.getAccountBranch());
		//accountCode 자동생성하는 메서드 
		int max = 0;
		String tempNumber = "account_";
		String accountNumber = "account_1";
		
		int resultNumber = bankAccountMapper.autoNumber();
		if(resultNumber != 0){
			max = resultNumber;
			//max = rs.getInt("maxcol");
			System.out.println(max + " <-- max 1");
			max = max + 1;
			System.out.println(max + " <-- max 2");
			accountNumber = tempNumber + max;
		}
		System.out.println("accountNumber -> " + accountNumber);
		//branch_manager값을 가져오는 메서드
		BankAccount resultBankAccount = bankAccountMapper.selectManager(bankAccount.getAccountBranch());
		//resultBankAccount에 저장된 매니저의 값을 bankAccount에 셋팅
		bankAccount.setAccountManager(resultBankAccount.getAccountManager());
		//자동증가된 accountNumber를 bankAccount객체 내의 AccountNumber에 셋팅
		bankAccount.setAccountNumber(accountNumber);
		//bankAccount를 매개변수로 입력받아 bankAccountMapper내의 bankInsert메서드 호출
		int result = bankAccountMapper.bankAccountInsert(bankAccount);
		return result;			
	}
	
	// 계좌 목록
	public List<BankAccount> bankAccountList(String memberId) {
		List<BankAccount> bankAccountList = bankAccountMapper.bankAccountAllSelect(memberId);
		System.out.println("BankAccountService - bankAccountList -> " + bankAccountList);
		return bankAccountList;
	}
	
	// 일반 회원 예수금 수정
	public int modifyAccountDeposit(BankAccount bankAccount) {
		return bankAccountMapper.updateAccountDeposit(bankAccount);
	}
	
	// 승인 전 계좌 신청 취소
	public int bankAccountRemove(HttpSession session, String accountNumber, String memberPw) {
		System.out.println("accountNumber -> " + accountNumber);
		System.out.println("memberPw -> " + memberPw);
		System.out.println("sessionPw -> " + session.getAttribute("sessionPw"));
		int result = 0;
		if(session.getAttribute("sessionPw").equals(memberPw)) {
			result = bankAccountMapper.bankAccountDelete(accountNumber);
		} else {
			result = 0;
		}
		return result;
	}
	
	// ADMIN 계정에서 승인 전 계좌 전체 조회
	public List<BankAccount> adminAccessList() {
		return bankAccountMapper.adminAccessSelect();
	}
	
	// 하나의 계좌를 승인
	public int adminAccessModfiy(BankAccount bankAccount) {
		return bankAccountMapper.adminAccessUpdate(bankAccount);
	}
}
