package com.skeye.water_fountain.biz.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class DeviceBean implements Serializable{
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device.device_no
     *
     * @mbggenerated
     */
    private String deviceNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device.device_name
     *
     * @mbggenerated
     */
    private String deviceName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device.product_name
     *
     * @mbggenerated
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device.model
     *
     * @mbggenerated
     */
    private String model;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device.product_date
     *
     * @mbggenerated
     */
    private Date productDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device.device_no
     *
     * @return the value of device.device_no
     *
     * @mbggenerated
     */
    public String getDeviceNo() {
        return deviceNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device.device_no
     *
     * @param deviceNo the value for device.device_no
     *
     * @mbggenerated
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device.device_name
     *
     * @return the value of device.device_name
     *
     * @mbggenerated
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device.device_name
     *
     * @param deviceName the value for device.device_name
     *
     * @mbggenerated
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device.product_name
     *
     * @return the value of device.product_name
     *
     * @mbggenerated
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device.product_name
     *
     * @param productName the value for device.product_name
     *
     * @mbggenerated
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device.model
     *
     * @return the value of device.model
     *
     * @mbggenerated
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device.model
     *
     * @param model the value for device.model
     *
     * @mbggenerated
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device.product_date
     *
     * @return the value of device.product_date
     *
     * @mbggenerated
     */
    public Date getProductDate() {
        return productDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device.product_date
     *
     * @param productDate the value for device.product_date
     *
     * @mbggenerated
     */
    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

	@Override
	public String toString() {
		return "Device [deviceNo=" + deviceNo + ", deviceName=" + deviceName + ", productName=" + productName
				+ ", model=" + model + ", productDate=" + productDate + "]";
	}
    
    
}