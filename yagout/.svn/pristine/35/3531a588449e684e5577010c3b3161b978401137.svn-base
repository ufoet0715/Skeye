package com.skeye.yagout.shiro;

/**
 * Created by Skeyedu on 2016/11/16.
 */
public enum RedidKeyEnum {

    USER_PERMS("userPerms", "用户权限"),
    USER_ROLES("userRoles", "用户角色"),
    USER_SESSION("userSession", "用户信息")

    ;




    private RedidKeyEnum(String code, String msg) {
        this.msg=msg;
        this.code = code;
    }

    private String code;
    private String msg;

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
    public static RedidKeyEnum find(String code) {
        for (RedidKeyEnum frs : RedidKeyEnum.values()) {
            if (frs.getCode().equals(code)) {
                return frs;
            }
        }
        return null;
    }


}
