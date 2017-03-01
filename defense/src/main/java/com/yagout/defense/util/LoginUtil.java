package com.yagout.defense.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yagout.defense.dal.model.Menu;
import com.yagout.defense.dal.model.Role;
import com.yagout.defense.dal.model.User;

public class LoginUtil {

	/**
	 * 把user转化为Set<String>
	 * @return stringSet
	 */
	public static Set<String> getUserStringSet(User user){
		Set<String> stringSet=new HashSet<String>();
		stringSet.add(String.valueOf(user.getUserId()));
		stringSet.add(user.getUserName());
		stringSet.add(user.getUserPwd());
		stringSet.add(user.getRemarks());
		stringSet.add(DateFormatter.dateFormat(user.getCreateTime()));
		return stringSet;
	}
	
	/**
	 * 把role转化为List<String>
	 * @return stringList
	 */
    public static List<String> getRoleStringList(Role role){
    	List<String> stringList=new ArrayList<String>();
    	stringList.add(String.valueOf(role.getRoleId()));
    	stringList.add(role.getRoleName());
        stringList.add(role.getRemark());
    	return stringList;
	}

    /**
	 * 把menu转化为List<String>
	 * @return stringList
	 */
    public static List<String> getMenuStringList(Menu menu){
    	List<String> stringList=new ArrayList<String>();
    	stringList.add(String.valueOf(menu.getMenuId()));
    	stringList.add(String.valueOf(menu.getParentId()));
    	stringList.add(menu.getName());
    	stringList.add(menu.getUrl());
    	stringList.add(menu.getPerms());
    	stringList.add(String.valueOf(menu.getMenuLevel()));
    	stringList.add(String.valueOf(menu.getOrderNum()));
    	return stringList;
    }
	
    /**
     * 把List<String>转化为Set<String>
     * @param stringList
     */
    public static void getStringSetByList(Set<String> stringSet,List<String> stringList){
		for (String string : stringList) {
			stringSet.add(string);
		}
    }
}
