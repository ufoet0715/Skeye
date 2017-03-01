package com.yagout.defense.biz.impl;

import com.yagout.defense.biz.UserBiz;
import com.yagout.defense.biz.bean.UserBean;
import com.yagout.defense.dal.model.User;
import com.yagout.defense.dal.model.UserExample;
import com.yagout.defense.service.UserLogService;
import com.yagout.defense.service.UserService;
import com.yagout.defense.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserBizImpl implements UserBiz {
	private static Logger logger = Logger.getLogger(UserBizImpl.class);
	// @Autowired
	// private LogService logService;
	@Autowired
	private UserService userService;
	// @Value("${nomalUserRole}")
	// @Autowired private Integer nomalUserRole;

	@Autowired
	private UserLogService userLogService;

	@Override
	public void queryUsersByPage(CommonPage commonPage) {
		List<Map<String, Object>> userses = userService.queryUserByPage(commonPage);
		commonPage.setPageData(ObjectUtil.transferListMap(userses, UserBean.class));
	}

	@Override
	public UserBean queryUsersById(Integer userId) {
		return (UserBean) ObjectUtil.transfer(userService.getUserById(userId), UserBean.class);
	}

	@Override
	public CommonResult checkUserName(String userName) {
		User users = userService.getUserByName(userName);
		CommonResult result = new CommonResult();
		if (users == null) {
			result.setIsSuccess(true);
		}
		return result;
	}

	@Override
	public CommonResult saveUser(UserBean usersBean) {
		CommonResult result = new CommonResult();
		boolean isSuccess = false;
		try {
			User users = userService.getUserByName(usersBean.getUserName());
			if (users != null) {
				result.setResultMsg("该登录名已经被使用");
				this.userLogService.insertUserLog(LogTypeEnum.TYPE_ADD_USER, isSuccess, usersBean.getUserName(),"该登录名已经被使用");
				return result;
			}
			User newUsers = new User();
			newUsers.setUserName(usersBean.getUserName());
			newUsers.setRemarks(usersBean.getRemarks());
			newUsers.setCreateTime(new Date());
			newUsers.setState(UserEnums.NORMALSTATE.getCode());
			newUsers.setUserPwd(MD5Util.MD5(usersBean.getUserPwd()));
			isSuccess = userService.saveUser(newUsers);
			if (isSuccess) {
				UserExample example = new UserExample();
				example.createCriteria().andUserNameEqualTo(newUsers.getUserName());
				List<UserBean> saveUser = userService.queryUsersList(example);
				for (UserBean userBean : saveUser) {
					newUsers.setUserId(userBean.getUserId());
				}
				isSuccess = userService.userAddRole(newUsers.getUserId(), usersBean.getRoleId());
				result.setIsSuccess(isSuccess);
				this.userLogService.insertUserLog(LogTypeEnum.TYPE_ADD_USER, isSuccess,(String)SecurityUtils.getSubject().getPrincipal(),"");
			}
		} catch (Exception e) {
			logger.error("保存用户异常", e);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_ADD_USER, isSuccess,(String)SecurityUtils.getSubject().getPrincipal(),"保存用户异常");
		}
		// Subject subject = SecurityUtils.getSubject();
		// logService.addLog((String)
		// subject.getPrincipal(),"添加登录用户",isSuccess,"添加的用户名为:"+usersBean.getUserName());
		return result;
	}

	@Override
	public CommonResult updateUser(String userName, Integer id, String lastPwd, String pwd) {
		User user = null;
		CommonResult result = new CommonResult();
		try {
			if (id != null) {
				user = userService.getUserById(id);
			} else {
				if (StringUtils.isNotEmpty(userName)) {
					user = userService.getUserByName(userName);
				}
			}
			if (user == null) {
				this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_USER, false, userName,"用户未找到");
				return new CommonResult(false, "用户未找到");
			}
			if (StringUtils.isNotEmpty(lastPwd) && !user.getUserPwd().equals(MD5Util.MD5(lastPwd))) {
				this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_USER, false, userName,"原始密码不正确");
				return new CommonResult(false, "原始密码不正确");
			}
			result.setIsSuccess(userService.updatePwd(user.getUserId(), MD5Util.MD5(pwd)));
			result.setData(user.getUserName());
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_USER, true, userName, "");
		} catch (Exception e) {
			logger.error("修改密码异常", e);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_USER, false, userName,"修改密码异常");
		}
		return result;
	}

	public CommonResult updateUserById(UserBean userBean) {
		boolean success = false;
		CommonResult result = new CommonResult();
		try {
			success = userService.updateById(userBean);
			result.setIsSuccess(success);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_USER, success, userBean.getUserName(),"");
		} catch (Exception e) {
			logger.error("修改用户异常", e);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_USER, success, userBean.getUserName(),"修改用户异常");
		}
		return result;
	}

	@Override
	public CommonResult deleteUsers(List<Integer> userIds) {
		CommonResult result = new CommonResult();
		try {
			result.setIsSuccess(userService.deleteUsers(userIds));
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_DELETE_USER, result.getIsSuccess(), "");
		} catch (Exception e) {
			logger.error("删除用户异常", e);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_DELETE_USER, result.getIsSuccess(), "删除用户异常");
		}
		// Subject subject = SecurityUtils.getSubject();
		// logService.addLog((String)
		// subject.getPrincipal(),"删除登录用户",result.getIsSuccess(),"删除的登录用户的id为:"+
		// JSONObject.toJSONString(ids));
		return result;
	}

	@Override
	public List<UserBean> queryUsersList() {
		UserExample example = new UserExample();
		return userService.queryUsersList(example);
	}

	@Override
	public User getUserForLogin(String userName, String password) {
		User user = this.userService.getUserForLogin(userName, password);
		return user;
	}

	@Override
	public User queryUserByName(String userName) {
		return this.userService.getUserByName(userName);
	}

	@Override
	public void setUserLogin(String userName, String password, String mac, CommonResult commonResult) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
        	
		if (!subject.isAuthenticated()) {
			try {
				AuthenticationToken token = new UsernamePasswordToken(userName, password);
				subject.login(token);
				commonResult.setIsSuccess(true);
			} catch (Exception e) {
				ObjectError objectError = new ObjectError("userName", e.getMessage());
				commonResult.setData(objectError);
			}
		}
		
		session.setAttribute("userName",userName);
		session.setAttribute("password",password);
	}
}
