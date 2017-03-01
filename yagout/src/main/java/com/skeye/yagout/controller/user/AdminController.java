package com.skeye.yagout.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.YagoutLogBiz;
import com.skeye.yagout.biz.YagoutUsersBiz;
import com.skeye.yagout.biz.bean.YagoutUsersBean;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/11/16.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    YagoutUsersBiz yagoutUsersBiz;

    @Autowired YagoutLogBiz yagoutLogBiz;

    @Value("${defaultPwd}")
  @Autowired  private  String defaultPwd;

    @RequestMapping("/userList")
    public String userList() {
        return "admin/userList";
    }

    @RequestMapping("/userListData")
    public ModelAndView userListData(CommonPage commonPage) {
        ModelAndView view = new ModelAndView("admin/userListData");
        yagoutUsersBiz.queryUsersByPage(commonPage);
        view.addObject("commonPage", commonPage);
        return view;
    }


    @RequestMapping("/logList")
    public String logList() {
        return "admin/logList";
    }

    @RequestMapping("/logListData")
    public ModelAndView logListData(CommonPage commonPage) {
        ModelAndView view = new ModelAndView("admin/logListData");
        yagoutLogBiz.logListData(commonPage);
        view.addObject("commonPage", commonPage);
        return view;
    }



    @RequestMapping(value = "/userEdit", produces = "text/html; charset=utf-8")
    public ModelAndView userEdit(@RequestParam(value = "userId", required = false) Integer userId) {
        ModelAndView view = new ModelAndView("admin/userEdit");
        if (userId != null) {
            YagoutUsersBean usersBean = yagoutUsersBiz.queryUsersById(userId);
            if (usersBean == null) {
                view.addObject("noDataToFind", true);
            }else {
                view.addObject("usersBean", usersBean);
            }
        }
        return view;
    }


    @RequestMapping(value = "/saveUser", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String saveUser(@Valid YagoutUsersBean usersBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            return  JSONObject.toJSONString(new CommonResult(false,errorList.get(0).getDefaultMessage()));
        }
        CommonResult result=yagoutUsersBiz.saveUser(usersBean);
        return JSONObject.toJSONString(result);
    }

    @RequestMapping(value = "/resetPwd", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String ResetPwd(YagoutUsersBean usersBean ) {
        CommonResult result=yagoutUsersBiz.updateUser(null,usersBean.getId(),null,defaultPwd);
        return JSONObject.toJSONString(result);
    }


    @RequestMapping(value = "/deleteUsers")
    @ResponseBody
    public String deleteUsers(@RequestBody  List<Integer> ids) {
        CommonResult result=yagoutUsersBiz.deleteUsers(ids);
        return JSONObject.toJSONString(result);
    }

}
