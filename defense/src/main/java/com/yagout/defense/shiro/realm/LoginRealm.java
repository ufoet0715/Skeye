package com.yagout.defense.shiro.realm;

import com.yagout.defense.biz.bean.LoginBean;
import com.yagout.defense.dal.model.Login;
import com.yagout.defense.dal.model.User;
import com.yagout.defense.redis.Constants;
import com.yagout.defense.redis.RedisCache;
import com.yagout.defense.redis.RedisKeyEnum;
import com.yagout.defense.service.LoginService;
import com.yagout.defense.service.UserService;
import com.yagout.defense.shiro.PasswordHelper;
import com.yagout.defense.util.LoginUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 
 * @author SCJ
 * 获得用户的权限和凭证
 * 处理redis的缓存
 */
public class LoginRealm extends AuthorizingRealm   {

	@Autowired private UserService userService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private RedisCache<String, Object> redisCache;

	public LoginRealm() {

	}

	/**
	 * 获得用户的权限，把结果放入redis的缓存中
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Set<String> roleStringSet=null;
		Set<String> menuStringSet=null;
		
		String userName = (String) super.getAvailablePrincipal(principals);
		
        //去缓存中查询 角色和权限;
		roleStringSet=	(Set<String>)redisCache.get(Constants.getRedisKey(RedisKeyEnum.USER_ROLES, userName));
		menuStringSet=	(Set<String>)redisCache.get(Constants.getRedisKey(RedisKeyEnum.USER_PERMS, userName));

        //缓存为空去数据库中查询
		if(roleStringSet==null||menuStringSet==null){
			roleStringSet=new HashSet<String>();
			menuStringSet=new HashSet<String>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userName", userName);

			List<Login> loginList=this.loginService.getLoginByMap(map);
			for (Login login : loginList) {
				LoginUtil.getStringSetByList(roleStringSet,LoginUtil.getRoleStringList(login.getRole()));
				LoginUtil.getStringSetByList(menuStringSet,LoginUtil.getMenuStringList(login.getMenu()));
			}
			redisCache.put(Constants.getRedisKey(RedisKeyEnum.USER_ROLES, userName), roleStringSet,5000);
			redisCache.put(Constants.getRedisKey(RedisKeyEnum.USER_PERMS, userName), menuStringSet,5000);
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roleStringSet);
		info.setStringPermissions(menuStringSet);

		return info;
	}

	/**
	 * 获得用户的认证，把结果放入redis的缓存中
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String userName = upToken.getUsername();
		User user = this.userService.getUserByName(userName);

		if (user == null) {
            throw new AuthenticationException("用户名不存在！");
        }

        LoginBean loginBean=new LoginBean();
        loginBean.setUser(user);
        
        PasswordHelper.encryptPassword(loginBean);

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginBean.getUser().getUserName(),
				loginBean.getUser().getUserPwd(),
				ByteSource.Util.bytes(loginBean.getCredentialsSalt()),
				super.getName());
        
		redisCache.put(Constants.getRedisKey(RedisKeyEnum.USER_SESSION, userName), LoginUtil.getUserStringSet(user),5000);

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
