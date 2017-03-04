package com.xqls.dal.dao;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.UserSet;

public interface UserSetDao {
    List<UserSet> getListByMap(Map<String,Object> map);
}
