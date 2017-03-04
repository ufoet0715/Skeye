package com.xqls.shiro.realm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.xqls.bean.LoginBean;
import com.xqls.dal.model.Login;
import com.xqls.dal.model.Permission;
import com.xqls.dal.model.Role;
import com.xqls.dal.model.User;
import com.xqls.redis.Constants;
import com.xqls.redis.RedisCache;
import com.xqls.redis.RedisKeyEnum;
import com.xqls.service.LoginService;
import com.xqls.service.UserService;
import com.xqls.shiro.PasswordHelper;
import com.xqls.util.ObjectUtil;

/**
 * 
 * @author SCJ
 * 获得用户的权限和凭证
 * 处理redis的缓存
 */
public class LoginRealm extends AuthorizingRealm implements Realm, InitializingBean {

	@Autowired private UserService userService;
	
	@Autowired private LoginService loginService;

	@Autowired
	private RedisCache<String, Object> redisCache;

	public LoginRealm() {

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	}

	/**
	 * 获得用户的权限，把结果放入redis的缓存中
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Set<String> roleStringSet=new HashSet<String>();
		Set<String> menuStringSet=new HashSet<String>();
		
		String userName = (String) super.getAvailablePrincipal(principals);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		
		
		List<Login> loginList=this.loginService.getLoginByMap(map);
		if(loginList!=null)
		{
			for (Login login : loginList) {
				ObjectUtil.getObjectStringSet(roleStringSet, login.getRole(), Role.class);
				ObjectUtil.getObjectStringSet(menuStringSet, login.getPermission(), Permission.class);
			}
			
			info.setRoles(roleStringSet);
			info.setStringPermissions(menuStringSet);

			redisCache.put(Constants.getRedisKey(RedisKeyEnum.USER_ROLES, userName), info.getRoles());
			redisCache.put(Constants.getRedisKey(RedisKeyEnum.USER_PERMS, userName), info.getStringPermissions());
		}

		return info;
	}

	/**
	 * 获得用户的认证，把结果放入redis的缓存中
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Set<String> userStringSet=new HashSet<String>();
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String userName = upToken.getUsername();
        String password=String.valueOf(upToken.getPassword());
		
		User user=this.userService.getUserListByLogin(userName, password).get(0);

        LoginBean loginBean=new LoginBean();
        loginBean.setUser(user);
        
        PasswordHelper.encryptPassword(loginBean);

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginBean.getUser().getUserName(),
				loginBean.getUser().getPassword(),
				ByteSource.Util.bytes(loginBean.getCredentialsSalt()),
				super.getName());
		
		ObjectUtil.getObjectStringSet(userStringSet, user, User.class);
		
		redisCache.put(Constants.getRedisKey(RedisKeyEnum.USER_SESSION, userName),userStringSet);

		return info;
	}

	/**
	 * 从redis的缓存中，移除指定用户的信息
	 * @param principal
	 */
	public void clearCachedAuthorizationInfo(String principal){
		SimplePrincipalCollection pc=new SimplePrincipalCollection(principal,super.getName());
		super.clearCachedAuthorizationInfo(pc);
		super.clearCachedAuthenticationInfo(pc);
		super.clearCache(pc);
		
		redisCache.remove(Constants.getRedisKey(RedisKeyEnum.USER_ROLES, principal));
		redisCache.remove(Constants.getRedisKey(RedisKeyEnum.USER_PERMS, principal));
	}
	
	/**
	 * 从redis的缓存中，移除所有用户的信息
	 */
	public void clearAllCachedAuthorizationInfo(){
		redisCache.clear();
	}
}
