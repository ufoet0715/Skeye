package com.skeye.water_fountain.dal.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeviceTwo {
	
    private String deviceNo;

    private String deviceName;

    private String productName;

    private String model;

    private String productDate;

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

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        this.productDate = simpleDateFormat.format(productDate);
    }

	@Override
	public String toString() {
		return "Device [deviceNo=" + deviceNo + ", deviceName=" + deviceName + ", productName=" + productName
				+ ", model=" + model + ", productDate=" + productDate + "]";
	}
}
