package com.skeye.water_fountain.dal.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeviceStateTwo {
	
    private String recordNo;

    private String deviceNo;

    private String deviceState;

    private Double waterTemperature;

    private String time;

	public String getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}

	public Double getWaterTemperature() {
		return waterTemperature;
	}

	public void setWaterTemperature(Double waterTemperature) {
		this.waterTemperature = waterTemperature;
	}

	public String getTime() {
		return time;
	}

	public void setTime(Date time) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.time = simpleDateFormat.format(time);
	}

	@Override
	public String toString() {
		return "DeviceStateTwo [recordNo=" + recordNo + ", deviceNo=" + deviceNo + ", deviceState=" + deviceState
				+ ", waterTemperature=" + waterTemperature + ", time=" + time + "]";
	}
}
