package com.xqls.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PermissionBean implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.perm_id
     *
     * @mbggenerated
     */
    private String permId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.perm_name
     *
     * @mbggenerated
     */
    private String permName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.parent_id
     *
     * @mbggenerated
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.level
     *
     * @mbggenerated
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.img_class
     *
     * @mbggenerated
     */
    private String imgClass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.tenant_no
     *
     * @mbggenerated
     */
    private String tenantNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.perm_id
     *
     * @return the value of permission.perm_id
     *
     * @mbggenerated
     */
    public String getPermId() {
        return permId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.perm_id
     *
     * @param permId the value for permission.perm_id
     *
     * @mbggenerated
     */
    public void setPermId(String permId) {
        this.permId = permId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.perm_name
     *
     * @return the value of permission.perm_name
     *
     * @mbggenerated
     */
    public String getPermName() {
        return permName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.perm_name
     *
     * @param permName the value for permission.perm_name
     *
     * @mbggenerated
     */
    public void setPermName(String permName) {
        this.permName = permName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.parent_id
     *
     * @return the value of permission.parent_id
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.parent_id
     *
     * @param parentId the value for permission.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.level
     *
     * @return the value of permission.level
     *
     * @mbggenerated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.level
     *
     * @param level the value for permission.level
     *
     * @mbggenerated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.url
     *
     * @return the value of permission.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.url
     *
     * @param url the value for permission.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.img_class
     *
     * @return the value of permission.img_class
     *
     * @mbggenerated
     */
    public String getImgClass() {
        return imgClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.img_class
     *
     * @param imgClass the value for permission.img_class
     *
     * @mbggenerated
     */
    public void setImgClass(String imgClass) {
        this.imgClass = imgClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.tenant_no
     *
     * @return the value of permission.tenant_no
     *
     * @mbggenerated
     */
    public String getTenantNo() {
        return tenantNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.tenant_no
     *
     * @param tenantNo the value for permission.tenant_no
     *
     * @mbggenerated
     */
    public void setTenantNo(String tenantNo) {
        this.tenantNo = tenantNo;
    }
}