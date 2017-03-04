package com.xqls.biz;

import java.util.Map;

import com.xqls.bean.UserRoleKeyBean;
import com.xqls.util.CommonPage;
import com.xqls.util.CommonResult;

public interface UserSetBiz {

	CommonResult insertUserSet(Map<String, Object> map);

	CommonResult updateUserSet(Map<String, Object> map);

	CommonResult deleteUserSet(UserRoleKeyBean userRoleKeyBean);

	void getListByPage(CommonPage commonPage);
}
