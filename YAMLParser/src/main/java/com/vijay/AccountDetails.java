package com.vijay;

public class AccountDetails {
	
	private String acccountType;
	private String bankName;
	private int accountId;
	private String holderName;
	
	public String getAcccountType() {
		return acccountType;
	}
	public void setAcccountType(String acccountType) {
		this.acccountType = acccountType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	@Override
	public String toString() {
		return "AccountDetails [acccountType=" + acccountType + ", bankName=" + bankName + ", accountId=" + accountId
				+ ", holderName=" + holderName + "]";
	}

}
