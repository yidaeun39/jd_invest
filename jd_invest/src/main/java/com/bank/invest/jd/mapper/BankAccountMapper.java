package com.bank.invest.jd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bank.invest.jd.vo.BankAccount;

@Mapper
public interface BankAccountMapper {
	//계좌매니저를 검색하기 위한 메서드
	BankAccount selectManager(String memberAddress);
	int autoNumber();
	int bankInsert(BankAccount bankAccount);
	
}
