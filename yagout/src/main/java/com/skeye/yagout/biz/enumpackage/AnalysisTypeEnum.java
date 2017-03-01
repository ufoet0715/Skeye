package com.skeye.yagout.biz.enumpackage;

/**
 * Created by Skeyedu on 2016/11/21.
 */
public enum   AnalysisTypeEnum {
    ACCOUNT_TYPE(0, "accountType"),//账户类型分析
    ADSL(1, "adslAccountEq"),
    IP(2, "ipAddr"),
    MAC(3, "macAddr");

    private AnalysisTypeEnum(Integer code, String msg) {
        this.msg=msg;
        this.code = code;
    }

    private Integer code;
    private String msg;

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
    public static AnalysisTypeEnum find(int code) {
        for (AnalysisTypeEnum frs : AnalysisTypeEnum.values()) {
            if (frs.getCode().intValue() == code) {
                return frs;
            }
        }
        return null;
    }
}