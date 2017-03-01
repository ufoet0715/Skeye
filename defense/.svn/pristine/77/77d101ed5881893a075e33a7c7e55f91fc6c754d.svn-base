package com.yagout.defense.util;

/**
 * Created by Skeyedu on 2016/12/15.
 */
public enum DictionaryEnums {
    FLAG(1, "告警标志"),ACCOUNT_TYPE(4,"账号类型"),ALARM_STATE(9,"告警状态"),READ_STATE(13,"Web读状态"),PRIVACY(16,"加密方式"),ONLINE(28,"在线标志"),
    EXCP_STATE(37,"例外状态"),MENU_LEVEL(33,"菜单层级"),IDENTITY(38,"身份"),ENCRYPT_WAY(44,"加密算法"),AUTH_WAY(52,"认证方式"),WPS(56,"WPS状态"),
    BROADCAST_SSID(59,"是否开启SSID广播"),EVENT_RESULT(62,"操作结果"),LOGIN_TIMEOUT(81,"超时时间"),LOGIN_NUMBER_OUT(82,"登录错误次数"),LOCK_TIME(83,"锁定时间"),
    INVADE_FLAG(84,"激活状态");

    private DictionaryEnums(Integer code, String msg) {

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
    public static DictionaryEnums find(int code) {
        for (DictionaryEnums frs : DictionaryEnums.values()) {
            if (frs.getCode().intValue() == code) {
                return frs;
            }
        }
        return null;
    }
}
