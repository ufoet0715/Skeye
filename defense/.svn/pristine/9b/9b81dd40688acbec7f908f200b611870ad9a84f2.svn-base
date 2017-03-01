package com.yagout.defense.util;

public enum LogTypeEnum {
    TYPE_LOGIN(0, "登录"),
    TYPE_LOGOUT(1, "注销"),
    TYPE_ADD_USER(2, "添加账户"),
    TYPE_UPDATE_USER(3, "修改账户属性"),
    TYPE_DELETE_USER(4, "删除账户"),
    TYPE_SET_AP(5, "设置单个AP为特殊对象"),
    TYPE_SET_CLIENT(6,"设置终端为特殊对象"),
    TYPE_CREATE_REPORT(7,"生成安全报告"),   
    TYPE_DOWNLOAD_REPORT(8,"下载安全报告"),
    TYPE_IGNORE_MAC(9,"忽略MAC"),
	TYPE_ALARM_QUERY(10,"查看告警信息"),
	TYPE_UPDATE_STATE(11,"修改状态"),
	TYPE_UPDATE_DEFENSE(12,"修改策略");

    private LogTypeEnum(Integer code,String msg) {
        this.msg = msg;
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
    public static LogTypeEnum find(int code) {
        for (LogTypeEnum frs : LogTypeEnum.values()) {
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
    LogTypeEnum frs =find(code);
        if(frs==null){
            return  null;
        }
        return frs.getMsg();
    }
    
    /**
     * 根据值查找枚举
     */
    public static LogTypeEnum findByMsg(String msg){
    	for (LogTypeEnum frs : LogTypeEnum.values()) {
            if (frs.getMsg().equals(msg)) {
            	
                return frs;
            }
        }
        return null;
    }
}
