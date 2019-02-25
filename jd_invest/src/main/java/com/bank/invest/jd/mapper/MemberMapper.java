package com.bank.invest.jd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bank.invest.jd.vo.Member;

@Mapper
public interface MemberMapper {
	// login 처리 SELECT문
	Member login(Member member);
	
	// 회원 가입 처리 INSERT문
	int memberInsert(Member member);
	
	// 마이 페이지 SELECT문
	Member getOneMember(String sessionId);
	
}
