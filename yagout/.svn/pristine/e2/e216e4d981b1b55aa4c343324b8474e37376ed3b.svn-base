package com.skeye.yagout.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.YagoutUsersBiz;
import com.skeye.yagout.biz.bean.YagoutUsersBean;
import com.skeye.yagout.dal.model.YagoutUsers;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.service.YagoutUsersService;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;
import com.skeye.yagout.util.MD5Util;
import com.skeye.yagout.util.ObjectUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/11/17.
 */
@Service
public class YagoutUsersBizImpl  implements YagoutUsersBiz {
    private static Logger logger = Logger.getLogger(YagoutUsersBizImpl.class);
    @Autowired  private LogService logService;
    @Autowired  private YagoutUsersService yagoutUsersService;
    @Value("${nomalUserRole}")
    @Autowired  private  Integer nomalUserRole;

    @Override
    public CommonResult deleteUsers(List<Integer> ids) {
        CommonResult result=new CommonResult();
        try {
        result.setIsSuccess(yagoutUsersService.deleteUsers(ids));
        }catch (Exception e){
            logger.error("删除登录用户异常",e);
        }
        Subject subject = SecurityUtils.getSubject();
        logService.addLog((String) subject.getPrincipal(),"删除登录用户",result.getIsSuccess(),"删除的登录用户的id为:"+ JSONObject.toJSONString(ids));
        return result;
    }

    @Override
    public CommonResult updateUser(String userName, Integer id,String lastPwd, String pwd) {
        YagoutUsers users=null;
        CommonResult result=new CommonResult();
        try {
        if(id!=null){
            users=yagoutUsersService.getUserById(id);
        }else {
            if (StringUtils.isNotEmpty(userName)){
                users=yagoutUsersService.getUserByName(userName);
            }
        }
        if (users==null){
            return  new CommonResult(false,"用户未找到");
        }
        if(StringUtils.isNotEmpty(lastPwd)&&!users.getPassword().equals(MD5Util.MD5(lastPwd))){
            return  new CommonResult(false,"原始密码不正确");
        }
        result.setIsSuccess(yagoutUsersService.updatePwd(users.getId(),MD5Util.MD5(pwd)));
        result.setData(users.getUserName());
        }catch (Exception e){
            logger.error("修改密码异常",e);
        }
        Subject subject = SecurityUtils.getSubject();
        logService.addLog((String) subject.getPrincipal(),"修改密码",result.getIsSuccess(),"修改的用户名为:"+users.getUserName());
        return result;
    }

    @Override
    public CommonResult checkUserName(String userName) {
        YagoutUsers users=  yagoutUsersService.getUserByName(userName);
        CommonResult result=new CommonResult();
        if(users==null){
            result.setIsSuccess(true);
        }
        return result;
    }

    @Override
    public void queryUsersByPage(CommonPage commonPage) {
        List<Map> userses=yagoutUsersService.queryUserByPage(commonPage);
        commonPage.setPageData(ObjectUtil.transferListMap(userses, YagoutUsersBean.class));
    }

    @Override
    public CommonResult saveUser(YagoutUsersBean usersBean) {
        CommonResult result=new CommonResult();
        boolean isSuccess=false;
        try {
            YagoutUsers users= yagoutUsersService.getUserByName(usersBean.getUserName());
            if(users!=null){
                result.setResultMsg("该登录名已经被使用");
                return  result;
            }
            YagoutUsers newUsers=new  YagoutUsers();
            newUsers.setUserName(usersBean.getUserName());
            newUsers.setPassword(MD5Util.MD5(usersBean.getPassword()));
            isSuccess=yagoutUsersService.saveUser(newUsers);
            if (isSuccess){
                isSuccess=  yagoutUsersService.userAddRole(newUsers.getId(),nomalUserRole);
                result.setIsSuccess(isSuccess);
            }
        }catch (Exception e){
            logger.error("保存用户异常",e);
        }
        Subject subject = SecurityUtils.getSubject();
        logService.addLog((String) subject.getPrincipal(),"添加登录用户",isSuccess,"添加的用户名为:"+usersBean.getUserName());
        return result;
    }

    @Override
    public YagoutUsersBean queryUsersById(Integer userId) {
        return   (YagoutUsersBean)ObjectUtil.transfer(yagoutUsersService.getUserById(userId) ,YagoutUsersBean.class);
    }
}
