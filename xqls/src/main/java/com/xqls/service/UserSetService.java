package com.xqls.service;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.UserSet;

public interface UserSetService {
    List<UserSet> getListByMap(Map<String,Object> map);
}
