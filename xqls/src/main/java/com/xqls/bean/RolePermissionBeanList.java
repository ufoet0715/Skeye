package com.xqls.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class RolePermissionBeanList implements Serializable{
	private List<RolePermissionBean> beanList=new ArrayList<RolePermissionBean>();

	public List<RolePermissionBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<RolePermissionBean> beanList) {
		this.beanList = beanList;
	}
		
}
