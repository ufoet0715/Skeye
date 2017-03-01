package com.skyeye.test.service;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyeye.test.BasicTest;
import com.skeye.yagout.service.YagoutUsersService;
import com.skeye.yagout.dal.model.YagoutPermissions;
import com.skeye.yagout.dal.model.YagoutUsers;
import com.skeye.yagout.service.YagoutPermissionsService;
public class ShiroTest extends BasicTest {
     @Autowired private YagoutUsersService YagoutUsersService;
     @Autowired   private YagoutPermissionsService YagoutPermissionsService;
	@Test
	public void test(){
		List<YagoutPermissions> list=	YagoutPermissionsService.getAllPermissions();
		System.out.println(list);
		String userName="ww";
		Set<String>  ps=	YagoutUsersService.getPermissionsByUserName(userName);
		System.out.println(ps);
		Set<String>  roles=YagoutUsersService.getRolesByName(userName);
		System.out.println(roles);
		YagoutUsers user=YagoutUsersService.getUserByName(userName);
		System.out.println(user);
	}

}
