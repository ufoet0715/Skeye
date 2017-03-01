package com.yagout.defense.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.UserLogAndTypeBiz;
import com.yagout.defense.dal.model.UserLogAndType;
import com.yagout.defense.service.UserLogAndTypeService;
import com.yagout.defense.util.CommonPage;

@Service
public class UserLogAndTypeBizImpl implements UserLogAndTypeBiz {

	@Autowired private UserLogAndTypeService userLogAndTypeService;
	
	@Override
	public void getUserLogAndTypeByPage(CommonPage commonPage) {
        List<UserLogAndType> list = this.userLogAndTypeService.getByMap(commonPage.pageToMap());
        commonPage.setPageData(list);
	}
}
