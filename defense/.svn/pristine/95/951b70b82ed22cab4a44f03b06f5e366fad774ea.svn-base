package com.yagout.defense.util;

/**
 * Created by Skeyedu on 2017/2/17.
 */
public enum ApRiskEnum {
    MAX_RISK(0, "极大安全风险","开启WPA2加密"),
    LESS_RISK(1, "较小的风险","设置为AES加密"),
    CERTAIN_RISK(2, "一定安全风险","关闭WPS");

    private ApRiskEnum(Integer code, String msg,String advice) {
        this.msg = msg;
        this.code = code;
        this.advice=advice;
    }

    private Integer code;
    private String msg;
    private String advice;

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 根据编码查找枚举
     */
    public static ApRiskEnum find(int code) {
        for (ApRiskEnum frs : ApRiskEnum.values()) {
            if (frs.getCode().intValue() == code) {
                return frs;
            }
        }
        return null;
    }

    /**
     * 根据编码查找枚举
     */
    public static String findMSG(int code) {
        ApRiskEnum frs =find(code);
        if(frs==null){
            return  null;
        }
        return frs.getMsg();
    }

}
