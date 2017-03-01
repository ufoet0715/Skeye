package com.skeye.water_fountain.dal.model;

public class AccountToDeviceTwo {
	private String id;
	private Account account;
	private Device device;
	private String productTime;
	private String time;

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

	public String getProductTime() {
		return productTime;
	}

	public void setProductTime(String productTime) {
		this.productTime = productTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "AccountToDeviceTwo [id=" + id + ", account=" + account + ", device=" + device + ", productTime="
				+ productTime + ", time=" + time + "]";
	}
}
