package com.skeye.yagout.biz.enumpackage;

/**
 * Created by Skeyedu on 2016/12/2.
 */
public enum LogTypeEnum {
           TYPE_LOGIN(0, "登录"),
            TYPE_LOGOUT(1, "登出"),
            TYPE_ADD_USER(2, "添加登录用户"),
            TYPE_DELETE_USER(3, "删除登录用户"),
            TYPE_CHANGE_PWD(4, "修改密码"),
            TYPE_DELETE_ACCOUNT(5, "删除账户信息"),
            TYPE_DELETE_ADSL(6, "删除ADSL帐号"),
            TYPE_DELETE_RACCOUNT(7, "删除账户轨迹"),
            TYPE_EXCEL(8, "excel导出");

    private LogTypeEnum(Integer code, String msg) {
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
}
