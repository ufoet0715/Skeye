package com.yagout.defense.dal.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.DefenseTypeDao;
import com.yagout.defense.dal.model.DefenseType;
import com.yagout.defense.dal.service.DefenseTypeMapper;

@Repository
public class DefenseTypeDaoImpl implements DefenseTypeDao {

	@Autowired private DefenseTypeMapper defenseTypeMapper;
	
	@Override
	public List<DefenseType> getDefenseTypeByMap(Map<String,Object> map){
		Map<String,Object> param=new HashMap<String, Object>();
		param.put("defenseParam", map);
		return this.defenseTypeMapper.getDefenseTypeByMap(param);
	}
}
