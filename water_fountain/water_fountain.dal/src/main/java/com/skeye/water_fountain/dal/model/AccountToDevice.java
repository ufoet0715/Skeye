package com.skeye.water_fountain.dal.model;

import java.util.Date;

public class AccountToDevice {
	private String id;
	private Account account;
	private Device device;
	private Date time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time=time;
	}

	@Override
	public String toString() {
		return "AccountToDevice [id=" + id + ", account=" + account + ", device=" + device + ", time=" + time + "]";
	}	
}
