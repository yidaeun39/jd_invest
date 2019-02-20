package com.bank.invest.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.invest.jd.service.JdInvestService;
import com.bank.invest.jd.vo.Member;

@Controller
public class JdInvestController {

	@Autowired
	private JdInvestService jdInvestSercive;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member resultMember = jdInvestSercive.login(member);
		System.out.println("resultMember -> " + resultMember);
		model.addAttribute("member", resultMember);
		return "index";
	}
	
}
