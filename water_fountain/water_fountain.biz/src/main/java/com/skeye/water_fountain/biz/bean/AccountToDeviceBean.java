package com.skeye.water_fountain.biz.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class AccountToDeviceBean implements Serializable{

	private String id;

    private String accountNo;

    private String accountName;

    private String password;

    private String telephone;

    private String deviceNo;

    private String deviceName;

    private String productName;

    private String model;

    private Date productDate;

	private String time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		if(productDate!=null && !productDate.equals(""))
		{
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
			Date dateValue = null;
			try {
				dateValue = simpleDateFormat.parse(productDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			this.productDate = dateValue;
		}
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(Date time) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.time = simpleDateFormat.format(time);
	}
}
