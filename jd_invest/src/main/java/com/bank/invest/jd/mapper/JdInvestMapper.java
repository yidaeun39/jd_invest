package com.bank.invest.jd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bank.invest.jd.vo.Member;

@Mapper
public interface JdInvestMapper {
	Member login(Member member);
}
