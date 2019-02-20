package com.bank.invest.jd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.invest.jd.mapper.MemberMapper;
import com.bank.invest.jd.vo.Member;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public Member login(Member member) {
		Member resultMember = memberMapper.login(member);
		return resultMember;
	}
	
	public int memberInsert(Member member) {
		if(member.getMemberAddress().equals("서신점")) {
			member.setBranchCode("b001");
		} else if(member.getMemberAddress().equals("호성점")) {
			member.setBranchCode("b002");
		} else if(member.getMemberAddress().equals("봉동점")) {
			member.setBranchCode("b003");
		} else if(member.getMemberAddress().equals("부산점")) {
			member.setBranchCode("b004");
		} 
		System.out.println("branchCode 확인 -> " + member.getBranchCode());
		int result = memberMapper.memberInsert(member);
		System.out.println("INSERT 쿼리 실행 여부 -> " + result);
		return result;
		
	}
	
	public Member myPage(String sessionId) {
		
		return memberMapper.myPage(sessionId);
		
	}
	
	
}
