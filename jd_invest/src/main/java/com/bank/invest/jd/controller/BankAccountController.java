package com.bank.invest.jd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.invest.jd.service.BankAccountService;
import com.bank.invest.jd.vo.BankAccount;

@Controller
public class BankAccountController {
	@Autowired private BankAccountService bankAccountService;
	
	@GetMapping("/bankAdd")
	public String bankAdd(){	
		//bankAdd 화면으로 이동
		return "bankAdd";
	}
	
	@PostMapping("/bankAdd")
	public String backAdd(HttpSession session, BankAccount bankAccount) {
		//sessionId 값을 bankAccount 객체 내의 memberId에 저장
		bankAccount.setMemberId((String)session.getAttribute("sessionId"));
		//memberAddress 값을 bankAccount 객체 내의 accountBranch에 저장
		bankAccount.setAccountBranch((String)session.getAttribute("memberAddress"));
		//bankAccountService 내의 bankAdd메서드에 매개변수 babkAccount를 입력함 
		int result = bankAccountService.bankAdd(bankAccount);
		System.out.println("bankAdd 결과는 : "+result);
		return "bankList";
	}
}
