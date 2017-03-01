package com.skeye.yagout.shiro;

import com.skeye.yagout.biz.bean.YagoutUsersBean;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private static  RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private static  String algorithmName = "md5";
    private static final int hashIterations = 2;

    public  static void encryptPassword(YagoutUsersBean user) {
        // User对象包含最基本的字段Username和Password
        // 将用户的注册密码经过散列算法替换成一个不可逆的新密码保存进数据，散列过程使用了盐
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
        user.setPassword(newPassword);
    }
}