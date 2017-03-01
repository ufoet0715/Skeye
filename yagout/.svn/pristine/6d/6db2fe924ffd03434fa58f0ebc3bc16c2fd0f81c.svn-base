package com.skeye.yagout.biz;

import com.skeye.yagout.biz.bean.YagoutUsersBean;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;

import java.util.List;

/**
 * Created by Skeyedu on 2016/11/17.
 */
public interface YagoutUsersBiz {

    public void  queryUsersByPage(CommonPage commonPage);

    public YagoutUsersBean queryUsersById(Integer userId);

    public CommonResult checkUserName(String userName);

    public CommonResult  saveUser(YagoutUsersBean usersBean);
    public CommonResult updateUser(String userName,Integer id,String lastPwd,String pwd);
    public CommonResult deleteUsers(List<Integer> userIds);
}
