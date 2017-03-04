package com.xqls.redis;

public enum RedisKeyEnum {
	USER_PERMS("userPerms","用户权限"),
	USER_ROLES("userRoles","用户角色"),
	USER_SESSION("userSession","用户信息");
	
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

	private RedisKeyEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	/**
     * 根据编码查找枚举
     */
	public static RedisKeyEnum find(String code){
		for(RedisKeyEnum rke:RedisKeyEnum.values())
		{
			if(rke.getCode().equals(code)){
				return rke;
			}
		}
		return null;
	}
}
