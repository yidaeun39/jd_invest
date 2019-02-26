package com.bank.invest.jd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String index() {
		//index 화면으로 이동
		return "index";
	}
	
	@GetMapping("/errorView")
	public String errorView() {
		return "errorView";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}	
}
