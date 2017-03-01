package com.yagout.defense.util;

/**
 * Created by Skeyedu on 2017/2/18.
 */
public enum ReportEnum {
    TAP_SIZE("apSize", "ap总量"),
    SAVEAP_SIZE("saveApSize", "安全ap总量"),
    SAVEAP_SHOW("saveApShow", "安全ap"),
    CHANNLE("channel", "信道表格"),
    RISK("risk", "风险ap"),
    STATION_SIZE("stationSize", "终端总量");

    private  String code;
    private  String msg;

    private ReportEnum(String code,String msg) {
        this.msg = msg;
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
    public static ReportEnum find(String code) {
        for (ReportEnum frs : ReportEnum.values()) {
            if (frs.getCode().equals(code)) {
                return frs;
            }
        }
        return null;
    }

    /**
     * 根据编码查找枚举
     */
    public static String findMSG(String code) {
        ReportEnum frs =find(code);
        if(frs==null){
            return  null;
        }
        return frs.getMsg();
    }

}
