package com.yagout.defense.biz.bean;

import java.util.Date;

public class ExceptionMacBean {
	
    private String mac;
    private String name;
    private String remarks;
    private Long createTime;
    private Long cnvalidTime;
    private Integer excpState;
    private Date createTimeBean;
    private Date cnvalidTimeBean;
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getCnvalidTime() {
		return cnvalidTime;
	}
	public void setCnvalidTime(Long cnvalidTime) {
		this.cnvalidTime = cnvalidTime;
	}
	public Integer getExcpState() {
		return excpState;
	}
	public void setExcpState(Integer excpState) {
		this.excpState = excpState;
	}
	public Date getCreateTimeBean() {
		return createTimeBean;
	}
	public void setCreateTimeBean(Date createTimeBean) {
		this.createTimeBean = createTimeBean;
	}
	public Date getCnvalidTimeBean() {
		return cnvalidTimeBean;
	}
	public void setCnvalidTimeBean(Date cnvalidTimeBean) {
		this.cnvalidTimeBean = cnvalidTimeBean;
	}
    
    
    
}