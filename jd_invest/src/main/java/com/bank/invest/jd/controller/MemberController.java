package com.bank.invest.jd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.invest.jd.service.MemberService;
import com.bank.invest.jd.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model, HttpSession session) {
		Member resultMember = memberService.login(member);
		System.out.println("resultMember -> " + resultMember);
		session.setAttribute("memberId", member.getMemberId());
		model.addAttribute("member", resultMember);
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("session 초기화 완료");
		return "redirect:/index";
	}
	
	@GetMapping("/memberAdd")
	public String memberAdd() {
		return "memberAdd";
	}
	
	@PostMapping("/memberAdd")
	public String memberAdd(Member member) {
		memberService.memberInsert(member);
		return "redirect:/login";
	}
}