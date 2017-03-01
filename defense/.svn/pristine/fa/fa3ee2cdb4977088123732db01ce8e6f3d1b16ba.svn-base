package com.yagout.defense.util;


public enum SoketEnum {

    DEVICE_STATE_CHANGE (0x2001, "检测前端状态变化通知"),
    WARNING_NOTICE(0x2002, "告警事件发生通知"),
    SAVE_DEVICE_MESSAGE(0x2101, "录入AP和终端信息更新通知"),
    UPDATE_STRATEGY_NOTICE(0x2102, "修改攻击事件响应策略通知"),
    UPGRADE_DEVICE(0x2103, "升级通知")
    ;




    private SoketEnum(int code, String msg) {
        this.msg=msg;
        this.code = code;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
    public static SoketEnum find(int code) {
        for (SoketEnum frs : SoketEnum.values()) {
            if (frs.getCode()==code) {
                return frs;
            }
        }
        return null;
    }


}
