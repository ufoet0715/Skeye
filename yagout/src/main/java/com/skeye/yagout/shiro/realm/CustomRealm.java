package com.skeye.yagout.shiro.realm;

import com.skeye.yagout.biz.bean.YagoutUsersBean;
import com.skeye.yagout.dal.model.YagoutUsers;
import com.skeye.yagout.service.YagoutUsersService;
import com.skeye.yagout.shiro.Constants;
import com.skeye.yagout.shiro.PasswordHelper;
import com.skeye.yagout.shiro.RedidKeyEnum;
import com.skeye.yagout.shiro.RedisCache;
import com.skeye.yagout.util.MD5Util;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomRealm extends AuthorizingRealm implements Realm, InitializingBean {


    @Autowired
    private YagoutUsersService userService;

    @Autowired
    private RedisCache<String, Object> redisCache;

    private Logger logger = Logger.getLogger(this.getClass());

    public CustomRealm() {
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //logger.info("授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String userName = (String) super.getAvailablePrincipal(principals);
        info.setRoles(userService.getRolesByName(userName));
        info.setStringPermissions(userService.getPermissionsByUserName(userName));
        redisCache.put(Constants.getRedisKey(RedidKeyEnum.USER_PERMS,userName), info.getStringPermissions());
        redisCache.put(Constants.getRedisKey(RedidKeyEnum.USER_ROLES,userName), info.getRoles());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        SimpleAuthenticationInfo info = null;
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String userName = upToken.getUsername();
        String password=new String(upToken.getPassword());
        logger.info("[用户:" + userName + "|系统权限认证]");
        YagoutUsers user = userService.getUserByName(userName);
        if (user == null) {
            throw new AuthenticationException("用户名不存在！");
        }
        if(!user.getPassword().equals(MD5Util.MD5(password))){
            throw new AuthenticationException("账户密码不正确！");
        }

//        if (user.getStatus() < EnumStatus.NORMAL.getStatus()) {
//            throw new UserInputException("您的帐号号已被限制登录，如需帮助请联系管理员！");
//        }
        YagoutUsersBean usersBean=new YagoutUsersBean(user.getUserName(),password,user.getId());
        PasswordHelper.encryptPassword(usersBean);
        redisCache.put(Constants.getRedisKey(RedidKeyEnum.USER_SESSION,userName), usersBean);
        info = new SimpleAuthenticationInfo(usersBean.getUserName(), usersBean.getPassword(),
                ByteSource.Util.bytes(usersBean.getCredentialsSalt()),
                getName());
        return info;
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        super.clearCachedAuthorizationInfo(principals);
        super.clearCache(principals);
        super.clearCachedAuthenticationInfo(principals);
        redisCache.remove(Constants.getRedisKey(RedidKeyEnum.USER_PERMS,principal));
        redisCache.remove(Constants.getRedisKey(RedidKeyEnum.USER_ROLES,principal));
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        redisCache.clear();
        /*Cache<Object, AuthenticationInfo> cache = getAuthenticationCache();
        if (null != cache) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }*/
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}