package com.yagout.defense.util;

public enum UserEnums {
	
	ABNORMALSTATE(0, "已删除"),NORMALSTATE(1, "正常");
	
	private UserEnums(Integer code, String msg) {

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
    public static UserEnums find(int code) {
        for (UserEnums frs : UserEnums.values()) {
            if (frs.getCode().intValue() == code) {
                return frs;
            }
        }
        return null;
    }
}
