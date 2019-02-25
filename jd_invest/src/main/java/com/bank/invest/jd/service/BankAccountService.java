package com.bank.invest.jd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.invest.jd.mapper.BankAccountMapper;
import com.bank.invest.jd.vo.BankAccount;

@Service
public class BankAccountService {
	@Autowired private BankAccountMapper bankAccountMapper;
	
	public int bankAdd(BankAccount bankAccount) {
		
		
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
		int result = bankAccountMapper.bankInsert(bankAccount);
		return result;			
	}	
}
