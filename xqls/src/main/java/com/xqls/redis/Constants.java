package com.xqls.redis;

public class Constants {
	/**
	 * 获得Redis中的key值
	 * @param redisKeyEnum 
	 * @param userName
	 * @return redisKey
	 */
    public static String getRedisKey(RedisKeyEnum redisKeyEnum,String userName){
    	return userName+redisKeyEnum.getCode();
    }
}
