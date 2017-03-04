package com.xqls.bean;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class RolePermissionKeyBeanList implements Serializable{
	private List<RolePermissionKeyBean> beanList;

	public List<RolePermissionKeyBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<RolePermissionKeyBean> beanList) {
		this.beanList = beanList;
	}
		
}
