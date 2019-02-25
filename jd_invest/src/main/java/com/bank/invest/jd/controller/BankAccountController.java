package com.bank.invest.jd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.invest.jd.service.BankAccountService;
import com.bank.invest.jd.vo.BankAccount;

@Controller
public class BankAccountController {
	@Autowired private BankAccountService bankAccountService;
	
	@GetMapping("/bankAccountAdd")
	public String bankAdd(){	
		//bankAdd 화면으로 이동
		return "bankAccountAdd";
	}
	
	@PostMapping("/bankAccountAdd")
	public String backAdd(HttpSession session, BankAccount bankAccount) {
		//sessionId 값을 bankAccount 객체 내의 memberId에 저장
		bankAccount.setMemberId((String)session.getAttribute("sessionId"));
		//memberAddress 값을 bankAccount 객체 내의 accountBranch에 저장
		bankAccount.setAccountBranch((String)session.getAttribute("memberAddress"));
		//bankAccountService 내의 bankAdd메서드에 매개변수 babkAccount를 입력함 
		int result = bankAccountService.bankAccountAdd(bankAccount);
		System.out.println("bankAdd 결과는 : "+result);
		return "bankAccountList";
	}
	
	@GetMapping("/bankAccountList") 
	public String bankAccountList(HttpSession session, Model model) {
		String memberid = (String)session.getAttribute("sessionId");
		List<BankAccount> bankAccountList = bankAccountService.bankAccountList(memberid);
		System.out.println("bankAccountList -> " + bankAccountList);
		model.addAttribute("accountDepositLsit", bankAccountList);
		return "bankAccountList";
	}
	
	@GetMapping("/bankAccountAccessList") 
	public String bankAccountAccessList(HttpSession session, Model model) {
		String memberid = (String)session.getAttribute("sessionId");
		List<BankAccount> bankAccountList = bankAccountService.bankAccountList(memberid);
		model.addAttribute("accountDepositList", bankAccountList);
		return "bankAccountAccessList";
	}
	
	@PostMapping("/bankAccountAccessList")
	public String bankAccountAccessList(BankAccount bankAccount) {
		int result = bankAccountService.modifyAccountDeposit(bankAccount);
		System.out.println("예수금 update 쿼리 결과 -> " + result);
		return "redirect:/bankAccountAccessList";
	}
	
	@GetMapping("/bankAccountRemove")
	public String bankAccountRemove(HttpSession session, String accountNumber, String memberPw) {
		int result = bankAccountService.bankAccountRemove(session, accountNumber, memberPw);
		System.out.println("DELETE 쿼리 실행 여부 -> " + result);
		return "bankAccountRemove";
	}
}
