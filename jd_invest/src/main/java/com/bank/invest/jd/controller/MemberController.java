package com.bank.invest.jd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.invest.jd.service.MemberService;
import com.bank.invest.jd.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	

	@GetMapping("/login")
	public String login() {
		//로그인 화면으로 이동
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, Member member) {
		//memberService내의 login 메서드 호출
		Member resultMember = memberService.login(member);		
		System.out.println("resultMember -> " + resultMember);
		//sessionId에 입력된 id값 저장
		session.setAttribute("sessionId", resultMember.getMemberId());
		session.setAttribute("memberPw", resultMember.getMemberPw());
		session.setAttribute("memberAddress", resultMember.getMemberAddress());
		//index 화면으로 이동
		return "index";	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션 초기화
		session.invalidate();		
		System.out.println("session 초기화 완료");
		//index 화면으로 리다이렉트
		return "redirect:/index";
	}
	
	@GetMapping("/memberAdd")
	public String memberAdd() {
		//memberAdd 화면으로 이동 
		return "memberAdd";
	}
	
	@PostMapping("/memberAdd")
	public String memberAdd(Member member) {
		//memberService 내의 memberAdd메서드 호출
		memberService.memberAdd(member);
		//index 화면으로 리다이렉트
		return "redirect:/index";
	}
	
	@GetMapping("/myPage")
	public String getOneMember(HttpSession session, Model model) {
		System.out.println("MemberController - getOneMember 메서드 실행");
		//memberService내의 getOneMember메서드 호출하여 member변수에 저장
		Member member = memberService.getOneMember((String)session.getAttribute("sessionId"));
		//값이 저장된 member를 화면으로 addAttribute
		model.addAttribute("member",member);
		System.out.println("mypage->"+member);
		//myPage 화면으로 이동
		return "myPage";
	}
	
	
}
