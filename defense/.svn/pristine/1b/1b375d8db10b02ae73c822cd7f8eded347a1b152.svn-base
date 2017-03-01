package com.yagout.defense.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.LoginCheckBiz;
import com.yagout.defense.biz.RoleBiz;
import com.yagout.defense.biz.UserBiz;
import com.yagout.defense.biz.bean.UserBean;
import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.dal.model.LoginCheck;
import com.yagout.defense.dal.model.User;
import com.yagout.defense.service.UserLogService;
import com.yagout.defense.util.ARPUtil;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.DateFormatter;
import com.yagout.defense.util.DictionaryEnums;
import com.yagout.defense.util.LogTypeEnum;
import com.yagout.defense.util.MD5Util;

/**
 * 用户管理功能
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserBiz usersBiz;
	@Autowired
	private RoleBiz roleBiz;
	@Autowired
	private LoginCheckBiz loginCheckBiz;
	@Autowired
	private DictionaryBiz dictionaryBiz;
	@Autowired
	private UserLogService userLogService;

	/*
	 * @Autowired private BasicDataSource basicDataSource;
	 */

	@Value("${defaultPwd}")
	@Autowired
	private String defaultPwd;

	@RequestMapping("/userList")
	public String userList() {
		return "user/userList";
	}

	@RequestMapping("/userListData")
	@ResponseBody
	public String userListData(HttpServletRequest request, CommonPage commonPage) {
		usersBiz.queryUsersByPage(commonPage);
		System.out.println(commonPage.toShowPage());
		return commonPage.toShowPage();
	}

	@RequestMapping(value = "/getRoleList")
	@ResponseBody
	public String getRoleList() {
		return JSONObject.toJSONString(roleBiz.queryRoleList());
	}

	@RequestMapping(value = "/show")
	public void show(HttpServletRequest request, @RequestParam("id[]") String id) {
		System.out.println(id);
	}

	@RequestMapping(value = "/listData")
	@ResponseBody
	public String listDate(@RequestParam(value = "id", required = false) Integer userId) {
		// 如果返回的是json数组就不需要加前后的方括号
		return "[" + JSONObject.toJSONString(usersBiz.queryUsersById(userId)) + "]";
	}
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public String insert(UserBean userBean){
		if(StringUtils.isEmpty(userBean.getUserPwd())){
			userBean.setUserPwd(defaultPwd);
		}
		userBean.setRoleId(Integer.valueOf(userBean.getRoleName()));
		return JSONObject.toJSONString(usersBiz.saveUser(userBean));
	}

	@RequestMapping(value = "/edit")
	@ResponseBody
	public String update(UserBean userBean, @RequestParam(value = "id", required = false) String userId,
			@RequestParam(value = "oper") String oper) {
		if ("edit".equals(oper)) {
			userBean.setRoleId(Integer.valueOf(userBean.getRoleName()));
			userBean.setRoleName(null);
			if (userId != null) {
				userBean.setUserId(Integer.valueOf(userId));
			}
			return JSONObject.toJSONString(usersBiz.updateUserById(userBean));
		} else if ("add".equals(oper)) {
			userBean.setRoleId(Integer.valueOf(userBean.getRoleName()));
			userBean.setRoleName(null);
			userBean.setUserPwd(MD5Util.MD5(defaultPwd));
			return JSONObject.toJSONString(usersBiz.saveUser(userBean));
		} else {
			List<Integer> userIds = new ArrayList<Integer>();
			String[] strArray = userId.split(",");
			List<String> ids = Arrays.asList(strArray);
			for (String id : ids) {
				userIds.add(Integer.valueOf(id));
			}
			return JSONObject.toJSONString(usersBiz.deleteUsers(userIds));
		}
	}

	@RequestMapping("/logList")
	public String logList() {
		return "admin/logList";
	}

	@RequestMapping("/logListData")
	public ModelAndView logListData(CommonPage commonPage) {
		ModelAndView view = new ModelAndView("admin/logListData");
		// usersBiz.logListData(commonPage);
		// view.addObject("commonPage", commonPage);
		return view;
	}

	@RequestMapping(value = "/userEdit")
	public ModelAndView userEdit() {
		ModelAndView view = new ModelAndView("user/userEdit");
		view.addObject("roleList", roleBiz.queryRoleList());
		return view;
	}

	@RequestMapping(value = "/saveUser", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String saveUser(@Valid UserBean usersBean, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<ObjectError> errorList = bindingResult.getAllErrors();
			return JSONObject.toJSONString(new CommonResult(false, errorList.get(0).getDefaultMessage()));
		}
		CommonResult result = usersBiz.saveUser(usersBean);
		return JSONObject.toJSONString(result);
	}

	@RequestMapping(value = "/reset")
	@ResponseBody
	public String reset(Integer userId) {
		UserBean userBean = usersBiz.queryUsersById(userId);
		if (userBean != null) {
			userBean.setUserId(userId);
			userBean.setUserPwd(MD5Util.MD5(defaultPwd));
			CommonResult commonResult = usersBiz.updateUserById(userBean);

			return JSONObject.toJSONString(commonResult);
		}
		return null;
	}

	@RequestMapping(value = "/deleteUsers")
	@ResponseBody
	public String deleteUsers(@RequestBody List<Integer> ids) {
		CommonResult result = usersBiz.deleteUsers(ids);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 利用resultful风格获取租户编号和密码 验证租户编号和密码是否正确 返回CommonResult的JSON格式
	 * 
	 * @param userName
	 * @param password
	 * @return commonResult
	 */
	@RequestMapping(value = "/checkUser/{userName}/{password}")
	@ResponseBody
	public String checkUser(HttpServletRequest request, @PathVariable String userName, @PathVariable String password) {
		String mac = ARPUtil.getMacByRequest(request);

		Calendar calendar = Calendar.getInstance();
		Date dateTime = calendar.getTime();
		long currentTime = dateTime.getTime();

		List<Dictionary> dictionaryList=this.dictionaryBiz.queryDictionaryForLogin(DictionaryEnums.LOGIN_TIMEOUT.getCode(), DictionaryEnums.LOGIN_NUMBER_OUT.getCode(),
				DictionaryEnums.LOCK_TIME.getCode());
		int errorLimit = Integer.parseInt(dictionaryList.get(1).getDictionaryValue());
		int minutes = Integer.parseInt(dictionaryList.get(2).getDictionaryValue());
		
		List<LoginCheck> loginCheckList = this.loginCheckBiz.getLoginCheckForLogin(userName, mac);

        CommonResult commonResult = checkLogin(userName, MD5Util.MD5(password), mac, currentTime, errorLimit, minutes, loginCheckList);

		if (commonResult.getIsSuccess()) {
			this.usersBiz.setUserLogin(userName, MD5Util.MD5(password), mac, commonResult);
		}

		this.userLogService.insertUserLog(LogTypeEnum.TYPE_LOGIN, commonResult.getIsSuccess(), userName,
				commonResult.getResultMsg());

		return JSONObject.toJSONString(commonResult);
	}

	@RequestMapping(value = "/userpasswordEdit")
	public ModelAndView passwordEdit(@RequestParam(value = "userName", required = false) String userName) {
		ModelAndView view = new ModelAndView("user/userpasswordEdit");
		view.addObject("user", usersBiz.queryUserByName(userName));
		return view;
	}

	@RequestMapping(value = "/userpasswordSave")
	@ResponseBody
	public String save(UserBean userBean, String newpassword) {
		userBean.setUserPwd(MD5Util.MD5(newpassword));
		CommonResult result = usersBiz.updateUserById(userBean);
		return JSONObject.toJSONString(result);
	}



	/**
	 * 判断是否可解锁
	 * 
	 * @param loginCheck
	 * @return boolean
	 */
	private boolean checkUnlockLogin(int minutes, long currentTime, LoginCheck loginCheck) {
		long createTime = DateFormatter.stringParse(loginCheck.getCreateTime()).getTime();
		return currentTime - createTime >= 1000 * 60 * minutes;
	}

	/**
	 * 插入数据到login_check
	 */
	private void insertLoginCheck(String userName, String mac, String createTime) {
		LoginCheck loginCheck = new LoginCheck();
		loginCheck.setUserName(userName);
		loginCheck.setMac(mac);
		loginCheck.setCreateTime(createTime);
		loginCheck.setErrorNum(1);

		this.loginCheckBiz.insertData(loginCheck);
	}

	/**
	 * 更新login_check
	 */
	private void updatetLoginCheck(int minutes,String createTime, LoginCheck loginCheck) {

		int num=1;
		if(!checkUnlockLogin(minutes,System.currentTimeMillis(),loginCheck)){
			num=loginCheck.getErrorNum() + 1;
		}
		loginCheck.setErrorNum(num);
		loginCheck.setCreateTime(createTime);
		this.loginCheckBiz.updateData(loginCheck);
	}
	private void deleteLoginCheck(String createTime, LoginCheck loginCheck) {
		loginCheck.setCreateTime(createTime);
		loginCheck.setErrorNum(0);
		this.loginCheckBiz.updateData(loginCheck);
	}

	/**
	 * 检查账户
	 */
	private CommonResult checkLogin(String userName, String password, String mac,long currentTime,int errorLimit,int minutes,List<LoginCheck> loginCheckList ) {
		CommonResult commonResult = new CommonResult();
		boolean isLocked = false;
		List<Long> rowIdList = null;
		/**
		 * 判断账户是否被锁定
		 */
		if (loginCheckList.size() > 0) {
			rowIdList = new ArrayList<Long>();
			for (LoginCheck loginCheck : loginCheckList) {
				if (loginCheck.getErrorNum() >= errorLimit) {
					if (checkUnlockLogin(minutes, currentTime, loginCheck)) {
						rowIdList.add(loginCheck.getRowId());
					} else {
						isLocked = true;
						break;
					}
				}
			}
		}

		if (!isLocked && rowIdList != null) {
			if (!rowIdList.isEmpty()) {
				this.loginCheckBiz.recoveLoginByList(rowIdList);
			}
		}

		Calendar calendar = Calendar.getInstance();
		String createTime = DateFormatter.dateFormat(calendar.getTime());
		/**
		 * 检查login
		 */
		if (isLocked) {
			commonResult.setIsSuccess(false);
			commonResult.setResultMsg("账户被锁定,请"+minutes+"分钟后再试!");
		} else {
			User user=this.usersBiz.getUserForLogin(userName, password);
			if (user!=null) {
				int userId = user.getUserId();
				Subject subject = SecurityUtils.getSubject();
				Session session = subject.getSession();
				session.setAttribute("userId", userId);
				for(LoginCheck  loginCheck:loginCheckList){
//					if(StringUtils.isEmpty(loginCheck.getUserName())){
//						deleteLoginCheck(createTime, loginCheck);
//					}else

						if(loginCheck.getUserName().equals(userName)){
						deleteLoginCheck(createTime, loginCheck);
					}
				}
                session.setTimeout(dictionaryBiz.queryDictionaryByEnum(DictionaryEnums.LOGIN_TIMEOUT));
				commonResult.setIsSuccess(true);
				commonResult.setResultMsg("登录成功！");
			} else {
				commonResult.setIsSuccess(false);



				boolean inserLoginCheck=true;
                boolean  inserMacCheck=true;
				if (loginCheckList.size() > 0) {
					for(LoginCheck  loginCheck:loginCheckList){
//						if(StringUtils.isEmpty(loginCheck.getUserName())){
//							updatetLoginCheck(createTime, loginCheck);
//							inserMacCheck=false;
//						}else

							if(loginCheck.getUserName().equals(userName)){
						   updatetLoginCheck(minutes,createTime ,loginCheck);
						   inserLoginCheck=false;
					   }
					}
					if(inserLoginCheck){
						insertLoginCheck(userName, mac, createTime);
					}
//					if(inserMacCheck){
//						insertLoginCheck( null, mac, createTime);
//					}
				} else {
					//insertLoginCheck(null, mac, createTime);
					insertLoginCheck(userName, mac, createTime);
				}
				
				commonResult.setResultMsg("用户名或密码错误！");
			}
		}
		return commonResult;
	}
}
