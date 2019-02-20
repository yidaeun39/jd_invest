package com.bank.invest.jd.vo;

import org.springframework.stereotype.Component;

@Component
public class Management {
	private String barnch_code;
	private String barnch_name;
	private String barnch_manager;
	public String getBarnch_code() {
		return barnch_code;
	}
	public void setBarnch_code(String barnch_code) {
		this.barnch_code = barnch_code;
	}
	public String getBarnch_name() {
		return barnch_name;
	}
	public void setBarnch_name(String barnch_name) {
		this.barnch_name = barnch_name;
	}
	public String getBarnch_manager() {
		return barnch_manager;
	}
	public void setBarnch_manager(String barnch_manager) {
		this.barnch_manager = barnch_manager;
	}
	@Override
	public String toString() {
		return "Management [barnch_code=" + barnch_code + ", barnch_name=" + barnch_name + ", barnch_manager="
				+ barnch_manager + "]";
	}

}
