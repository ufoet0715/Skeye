package com.yagout.defense.util;

import com.yagout.defense.service.impl.StationTrustServiceImpl;


public enum MacType {
	STATION_TRUST((byte)5,"保护终端",StationTrustServiceImpl.class);
	private byte code;
	private String typeName;
	private Class<? extends Object> serviceClass;
	public Class<? extends Object> getServiceClass() {
		return serviceClass;
	}
	public void setServiceClass(Class<? extends Object> serviceClass) {
		this.serviceClass = serviceClass;
	}
	public byte getCode() {
		return code;
	}
	public void setCode(byte code) {
		this.code = code;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	private MacType(byte code, String typeName, Class<? extends Object> serviceClass) {
		this.code = code;
		this.typeName = typeName;
		this.serviceClass = serviceClass;
	}
	
	
	
	
}
