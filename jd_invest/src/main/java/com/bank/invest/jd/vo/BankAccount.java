package com.bank.invest.jd.vo;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {
	private String accountNumber;
	private String memberId;
	private String accountName;
	private String accountDeposit;
	private String accountBranch;
	private String accountManager;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountDeposit() {
		return accountDeposit;
	}
	public void setAccountDeposit(String accountDeposit) {
		this.accountDeposit = accountDeposit;
	}
	public String getAccountBranch() {
		return accountBranch;
	}
	public void setAccountBranch(String accountBranch) {
		this.accountBranch = accountBranch;
	}
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", memberId=" + memberId + ", accountName=" + accountName
				+ ", accountDeposit=" + accountDeposit + ", accountBranch=" + accountBranch + ", accountManager="
				+ accountManager + "]";
	}

}
