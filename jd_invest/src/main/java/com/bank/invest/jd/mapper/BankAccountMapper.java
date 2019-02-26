package com.bank.invest.jd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bank.invest.jd.vo.BankAccount;

@Mapper
public interface BankAccountMapper {
	//계좌매니저를 검색하기 위한 메서드
	BankAccount selectManager(String memberAddress);
	// 계좌를 자동생성하기 위한 메서드
	int autoNumber();
	// 계좌 신청하기 위한 메서드
	int bankAccountInsert(BankAccount bankAccount);
	// 계좌 리스트를 조회하기 위한 메서드
	List<BankAccount> bankAccountAllSelect(String memberId);
	// 예수금을 업데이트하기 위한 메서드
	int updateAccountDeposit(BankAccount bankAccount);
	// 승인 전 계좌를 취소하기 위한 메서드
	int bankAccountDelete(String accountNumber);
	// 관리자가 신청한 계좌를 승인하기 위한 메서드
	List<BankAccount> adminAccessSelect();
	// 하나의 계좌를 승인하기 위한 메서드
	int adminAccessUpdate(BankAccount bankAccount);
}
