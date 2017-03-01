package com.skeye.yagout.dal.model;

public class RawaccountHandledAndAccountType {
	private String accountName;
	private String password;
	private int accountType;
	private String typeName;
	private String adslAccount;
	private String ipAddr;
	private String macAddr;
	private int count;
	private String timeShow;

	public String getTimeShow() {
		return timeShow;
	}

	public void setTimeShow(String timeShow) {
		this.timeShow = timeShow;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAdslAccount() {
		return adslAccount;
	}

	public void setAdslAccount(String adslAccount) {
		this.adslAccount = adslAccount;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getMacAddr() {
		return macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RawaccountHandledAndAccountType [accountName=" + accountName + ", password=" + password
				+ ", accountType=" + accountType + ", typeName=" + typeName + ", adslAccount=" + adslAccount
				+ ", ipAddr=" + ipAddr + ", macAddr=" + macAddr + ", count=" + count + "]";
	}
}
