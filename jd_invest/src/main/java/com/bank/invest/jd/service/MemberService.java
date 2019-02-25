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
		//memberMapper내에 login메서드 호출
		Member resultMember = memberMapper.login(member);
		//리턴된 값을 resultMember에 저장후 리턴
		return resultMember;
	}
	
	public int memberAdd(Member member) {
		//주소별로 지점코드를 지정
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
		//memberMapper내의 memberInsert메서드 호출 후 result변수에 저장후 리턴
		int result = memberMapper.memberInsert(member);
		System.out.println("INSERT 쿼리 실행 여부 -> " + result);
		return result;
		
	}

	public Member getOneMember(String sessionId) {
		System.out.println("MemberService - getOneMember 메서드 실행");
		//memberMapper내의 getOneMember메서드 호출후 리턴
		return memberMapper.getOneMember(sessionId);
	}
	
	
}
