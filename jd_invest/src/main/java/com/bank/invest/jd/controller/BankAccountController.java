package com.bank.invest.jd.controller;

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
	
	// 일반 회원 계좌 신청
	@PostMapping("/bankAccountAdd")
	public String backAdd(HttpSession session, BankAccount bankAccount) {
		//sessionId 값을 bankAccount 객체 내의 memberId에 저장
		bankAccount.setMemberId((String)session.getAttribute("sessionId"));
		//memberAddress 값을 bankAccount 객체 내의 accountBranch에 저장
		bankAccount.setAccountBranch((String)session.getAttribute("memberAddress"));
		//bankAccountService 내의 bankAdd메서드에 매개변수 babkAccount를 입력함 
		int result = bankAccountService.bankAccountAdd(bankAccount);
		System.out.println("bankAdd 결과는 : "+result);
		return "redirect:/bankAccountList";
	}
	
	// 승인 전 계좌 목록 조회
	@GetMapping("/bankAccountList") 
	public String bankAccountList(HttpSession session, Model model) {
		String memberid = (String)session.getAttribute("sessionId");
		List<BankAccount> bankAccountList = bankAccountService.bankAccountList(memberid);
		System.out.println("bankAccountList -> " + bankAccountList);
		model.addAttribute("accountDepositLsit", bankAccountList);
		return "bankAccountList";
	}
		
	// 활성화 계좌 목록 조회
	@GetMapping("/bankAccountAccessList") 
	public String bankAccountAccessList(HttpSession session, Model model) {
		String memberid = (String)session.getAttribute("sessionId");
		List<BankAccount> bankAccountList = bankAccountService.bankAccountList(memberid);
		model.addAttribute("accountDepositList", bankAccountList);
		return "bankAccountAccessList";
	}
	
	// 일반 회원 예수금 수정
	@PostMapping("/bankAccountAccessList")
	public String bankAccountAccessList(BankAccount bankAccount) {
		int result = bankAccountService.modifyAccountDeposit(bankAccount);
		System.out.println("예수금 update 쿼리 결과 -> " + result);
		return "redirect:/bankAccountAccessList";
	}
	
	// 승인 전 계좌 신청 취소 화면
	@GetMapping("/bankAccountRemove")
	public String bankAccountRemove(Model model, String accountNumber) {
		model.addAttribute("accountNumber", accountNumber);
		return "bankAccountRemove";
	}
	
	// 승인 전 계좌 신청 취소 action
	@PostMapping("/bankAccountRemove")
	public String bankAccountRemove(HttpSession session, Model model, String accountNumber, String memberPw) {
		int result = bankAccountService.bankAccountRemove(session, accountNumber, memberPw);
		System.out.println("DELETE 쿼리 실행 여부 -> " + result);
		model.addAttribute("result", result);
		return "redirect:/bankAccountList";
	}
	
	// 승인 전 전체 계좌 목록 조회
	@GetMapping("/adminAccessList")
	public String adminAccessList(Model model) {
		List<BankAccount> adminAccessList = bankAccountService.adminAccessList();
		model.addAttribute("adminAccessList", adminAccessList);
		return "adminAccessList";
	}
	
	// 하나의 계좌 승인 action
	@PostMapping("/adminAccessList")
	public String adminAccessList(BankAccount bankAccount) {
		int result = bankAccountService.adminAccessModfiy(bankAccount);
		System.out.println("UPDATE 쿼리 실행 여부 -> " + result);
		return "redirect:/adminAccessList";
	}
}
