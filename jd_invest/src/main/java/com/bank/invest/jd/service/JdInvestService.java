package com.bank.invest.jd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.invest.jd.mapper.JdInvestMapper;
import com.bank.invest.jd.vo.Member;

@Service
@Transactional
public class JdInvestService {
	
	@Autowired
	private JdInvestMapper jdInvestMapper;
	
	public Member login(Member member) {
		Member resultMember = jdInvestMapper.login(member);
		return resultMember;
	}
}
