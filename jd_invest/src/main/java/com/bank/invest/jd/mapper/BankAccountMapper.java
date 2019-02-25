package com.bank.invest.jd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bank.invest.jd.vo.BankAccount;

@Mapper
public interface BankAccountMapper {
	//계좌매니저를 검색하기 위한 메서드
	BankAccount selectManager(String memberAddress);
	int autoNumber();
	int bankAccountInsert(BankAccount bankAccount);
	List<BankAccount> bankAccountAllSelect(String memberId);
	int updateAccountDeposit(BankAccount bankAccount);
	int bankAccountDelete(String accountNumber);
}
