package com.yagout.defense.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.yagout.defense.biz.bean.LoginBean;

/**
 * 
 * @author SCJ
 * 密码加密工具类
 */
public class PasswordHelper {
	/**
	 * 设置算法名称为MD5
	 */
    private static String algorithmName="md5";
    
    /**
     * 设置加密迭代次数
     */
    private static final int hashIterations=2;
    
    /**
     * 通过哈希算法加密密码
     * @param loginBean
     */
    public static void encryptPassword(LoginBean loginBean){
    	String newPassword=new SimpleHash(algorithmName, loginBean.getUser().getUserPwd(), 
    		ByteSource.Util.bytes(loginBean.getCredentialsSalt()), hashIterations).toHex();
    	loginBean.getUser().setUserPwd(newPassword);
    }
}
