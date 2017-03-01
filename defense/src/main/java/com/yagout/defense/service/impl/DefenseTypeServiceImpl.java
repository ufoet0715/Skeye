package com.yagout.defense.service.impl;

import com.yagout.defense.dal.dao.DefenseTypeDao;
import com.yagout.defense.dal.model.DefenseType;
import com.yagout.defense.service.DefenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DefenseTypeServiceImpl implements DefenseTypeService {

	@Autowired
	private DefenseTypeDao defenseTypeDao;
	
	@Override
	public List<DefenseType> getDefenseTypeByMap(Map<String,Object> map){
		return this.defenseTypeDao.getDefenseTypeByMap(map);
	}  
}
