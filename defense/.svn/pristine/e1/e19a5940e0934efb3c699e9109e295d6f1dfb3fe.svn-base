package com.yagout.defense.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yagout.defense.biz.LoginBiz;

/**
 * 
 * @author SCJ Login的Controller类
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {

	@Autowired
	private LoginBiz loginBiz;

	/**
	 * 判断当前账户是否已经登录 返回 ModelAndView
	 * 
	 * @return String
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/login";
	}

	@RequestMapping("/permNo")
	public String permNo() {
		return "/permNo";
	}

	/**
	 * 注销当前账户 返回 ModelAndView
	 * 
	 * @return view
	 */
	@RequestMapping("/loginOut")
	public String loginOut() {
		this.loginBiz.loginOut();
		return "redirect:/login.html";
	}

	/**
	 * 利用resultful风格获取账户名称和密码 将租户编号存入session 用户登录系统，获得对应的界面 返回 ModelAndView
	 * 
	 * @param userName
	 * @param password
	 * @return view
	 */
	@RequestMapping("/login")
	public ModelAndView login() {

		ModelAndView view = new ModelAndView();

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		if (session == null) {
			view.setViewName("/login");
		} else {
			view.setViewName("redirect:/index");
		}

		return view;
	}
}
