package com.yagout.defense.dal.dao.mybatis;

import com.yagout.defense.dal.dao.UpdateDao;
import com.yagout.defense.dal.service.UpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Skeyedu on 2017/2/14.
 */
@Repository
public class UpdateDaoImpl implements UpdateDao {

@Autowired
UpdateMapper updateMapper;
    @Override
    public boolean sqlUpdate(String sql) {
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("executeSql",sql);
        System.out.println(map.get("executeSql"));
        return updateMapper.sqlUpdate(map)>0;
    }
}
