package com.yagout.defense.biz;

import com.yagout.defense.biz.bean.UserBean;
import com.yagout.defense.dal.model.User;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;

import java.util.List;

/**
 * Created by Skeyedu on 2017/2/7.
 */
public interface UserBiz {

    public void  queryUsersByPage(CommonPage commonPage);

    public UserBean queryUsersById(Integer userId);

    public CommonResult checkUserName(String userName);

    public CommonResult saveUser(UserBean usersBean);
    public CommonResult updateUser(String userName,Integer id,String lastPwd,String pwd);
    public CommonResult deleteUsers(List<Integer> userIds);
    
    public CommonResult updateUserById(UserBean userBean);
    
    public List<UserBean> queryUsersList();
    
    User getUserForLogin(String userName, String password);
    
    User queryUserByName(String userName);
    
    void setUserLogin(String userName,String password ,String mac,CommonResult commonResult);
}
