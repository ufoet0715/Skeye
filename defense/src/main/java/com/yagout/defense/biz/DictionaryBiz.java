package com.yagout.defense.biz;


import com.yagout.defense.biz.bean.DictionaryBean;
import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.DictionaryEnums;

import java.util.List;
import java.util.Map;

public interface DictionaryBiz {

    public boolean editDictionary(DictionaryBean dictionary);

    public boolean editDictionaryList(List<DictionaryBean> dictionary);

    public Map<Integer,String> queryDictionaryByParent(Integer parent);

    public   Map<Integer,Map<Integer, String>>   queryDictionaryWithChildren();

    public void queryDictionaryByPage(CommonPage commonPage);

    public boolean deleteDictionary(Integer ids);

    public List<DictionaryBean> queryAllDictionary();
    
    Dictionary queryDictionaryByPrimary(Integer dictionaryKey);

    Long queryDictionaryByEnum(DictionaryEnums dictionaryEnums);

    List<Dictionary> queryDictionaryForLogin(int outKey,int errorKey, int lockKey);
}