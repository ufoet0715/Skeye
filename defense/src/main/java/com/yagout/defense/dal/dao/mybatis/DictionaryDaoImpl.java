package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yagout.defense.dal.dao.DictionaryDao;
import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.dal.model.DictionaryExample;
import com.yagout.defense.dal.model.DictionaryWithChildren;
import com.yagout.defense.dal.service.DictionaryMapper;

/**
 * Created by Skeyedu on 2016/12/15.
 */
@Component
public class DictionaryDaoImpl extends BaseDao implements DictionaryDao {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Override
    public boolean addDictionary(Dictionary dictionary) {


        return getResultByInt(dictionaryMapper.insertSelective(dictionary));
    }

    @Override
    public boolean editDictionary(Dictionary dictionary ) {
        return getResultByInt(dictionaryMapper.updateByPrimaryKeySelective(dictionary));
    }

    @Override
    public List<Dictionary> queryDictionaryByPage(Map<String, Object> map) {
        return dictionaryMapper.queryDictionaryByPage(map);
    }

    @Override
    public List<Dictionary> queryDictionary(DictionaryExample example) {
        return dictionaryMapper.selectByExample(example);
    }

    @Override
    public List<DictionaryWithChildren> queryDictionaryWithChildren(Map<String, Object> map) {
        return dictionaryMapper.queryDictionaryWithChildren(map);
    }

    @Override
    public boolean deleteDictionary(Integer id) {
        return getResultByInt( dictionaryMapper.deleteDictionary(id));
    }
}
