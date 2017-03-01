package com.yagout.defense.biz.impl;


import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.bean.DictionaryBean;
import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.dal.model.DictionaryWithChildren;
import com.yagout.defense.redis.RedisCache;
import com.yagout.defense.service.DictionaryService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.DictionaryEnums;
import com.yagout.defense.util.ObjectUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/12/15.
 */
@Service
public class DictionaryBizImpl implements DictionaryBiz {
    private  static  final  String  ALLDICTIONARY="ALLDICTIONARY";
    private  static  final  String  DICTIONARYWITHCHILDREN="DICTIONARYWITHCHILDREN";
    public   static  final  String  DICTION_TIMEOUT="DICTION_TIMEOUT";
    private static Logger logger = Logger.getLogger(DictionaryBizImpl.class);
    @Autowired
    private RedisCache<String, Object> redisCache;

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public boolean editDictionary(DictionaryBean dictionary) {
        return editDictionary(dictionary,true) ;
    }

    private  boolean  editDictionary(DictionaryBean dictionary,boolean clear){
        boolean success=false ;
        try{
            if (dictionary.getDictionaryKey()!=null){
                success= dictionaryService.editDictionary((Dictionary) ObjectUtil.transfer(dictionary,Dictionary.class));
            }else {
                if(dictionary.getRemoveAble()==null){
                    dictionary.setRemoveAble(true);
                }
                success= dictionaryService.addDictionary((Dictionary)ObjectUtil.transfer(dictionary,Dictionary.class));
            }
            if(success&&clear){
                clear();
            }
        }catch (Exception e){
            logger.error("修改字典异常",e);
        }

        return success;
    }




    @Override
    public boolean editDictionaryList(List<DictionaryBean> dictionarys) {
        boolean success=false ;
        try{
            for(int i=0 ;i<dictionarys.size();i++){
                editDictionary(dictionarys.get(i),i==dictionarys.size()-1) ;
            }
            success=true;
        }catch (Exception e){
            logger.error("修改字典异常",e);
        }

        return success;
    }

    @Override
    public Map<Integer, String> queryDictionaryByParent(Integer parent) {
        Map<Integer, Map<Integer, String>> data= queryDictionaryWithChildren();
        if (data==null) return null;
        return data.get(parent);
    }

    @SuppressWarnings("unchecked")
	@Override
    public Map<Integer, Map<Integer, String>> queryDictionaryWithChildren() {
        Map<Integer, Map<Integer, String>> data=null;
        try{
       data=  ( Map<Integer, Map<Integer, String>>)redisCache.get(DICTIONARYWITHCHILDREN);
          if (data==null||data.size()==0){
                List<DictionaryWithChildren> dictionaryWithChildrens=    dictionaryService.queryDictionaryWithChildren(null);
              if(dictionaryWithChildrens!=null&&dictionaryWithChildrens.size()>0){
                  data=new HashMap<Integer, Map<Integer, String>> ();
                  for (DictionaryWithChildren dictionaryWithChildren:dictionaryWithChildrens){
                      data.put(dictionaryWithChildren.getDictionaryKey(),dictionaryToMap(dictionaryWithChildren.getChildren()));
                  }
                  redisCache.put(DICTIONARYWITHCHILDREN,data,50000);
              }
          }
        }catch (Exception e){
            logger.error("查询字典异常",e);
        }
        return data;
    }

    @Override
    public void queryDictionaryByPage(CommonPage commonPage) {
        try{
        List<Dictionary> data=  dictionaryService.queryDictionaryByPage(commonPage.pageToMap());
        commonPage.setPageData(ObjectUtil.transferList(data,DictionaryBean.class));
        }catch (Exception e){
            logger.error("查询字典分页异常",e);
        }
    }

    @Override
    public boolean deleteDictionary(Integer ids) {
        boolean success=false;
        try{
            Dictionary dictionary=     dictionaryService.queryDictionaryById(ids);
            if(!dictionary.getRemoveAble()){
                return  false;
            }
                success=dictionaryService.deleteDictionary(ids);
                if(success){
                    clear();
                }
        }catch (Exception e){
            logger.error("删除字典异常",e);
        }
        return success;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<DictionaryBean> queryAllDictionary() {
        List<DictionaryBean> data=null;
        try{
        data=(List<DictionaryBean>)redisCache.get(ALLDICTIONARY);
        if (data==null||data.size()==0){
            List<Dictionary> dictionaries=    dictionaryService.queryAllDictionary();
            if(dictionaries!=null&&dictionaries.size()>0){
                data=ObjectUtil.transferList(dictionaries,DictionaryBean.class);
                redisCache.put(ALLDICTIONARY,data,50000);
            }
        }
        }catch (Exception e){
            logger.error("查询所有字典异常",e);
        }
        return data;

    }

    private void  clear(){
        redisCache.remove(DICTIONARYWITHCHILDREN);
        redisCache.remove(ALLDICTIONARY);
    }



    private  Map<Integer,String> dictionaryToMap( List<Dictionary> list){
        Map<Integer,String>  map=new HashMap<Integer,String>();
        if (list==null||list.size()==0)return map;
        for (Dictionary dictionary:list){
            map.put(dictionary.getDictionaryKey(),dictionary.getDictionaryValue());
        }
        return map;
    }

    @Override
    public Long queryDictionaryByEnum(DictionaryEnums dictionaryEnums) {
        if (DictionaryEnums.LOGIN_TIMEOUT.equals(dictionaryEnums)){

          Long timeOut=null;
            try{
                timeOut=(Long)redisCache.get(DICTION_TIMEOUT);
                if (timeOut==null){
                    Dictionary dictionarie=queryDictionaryByPrimary(dictionaryEnums.getCode());
                    if(dictionarie!=null){
                        timeOut=Long.parseLong(dictionarie.getDictionaryValue());
                        if(timeOut==null){
                            timeOut=300000l;
                        }else {
                            timeOut=timeOut*60000;
                        }
                        redisCache.put(DICTION_TIMEOUT,timeOut,50000);
                    }
                }
            }catch (Exception e){
                logger.error("查询所有字典异常",e);
            }
            if(timeOut==null)timeOut=300000l;
            return timeOut;
        }
        return null;
    }

    @Override
	public Dictionary queryDictionaryByPrimary(Integer dictionaryKey) {

		return this.dictionaryService.queryDictionaryById(dictionaryKey);
	}

	@Override
	public List<Dictionary> queryDictionaryForLogin(int outKey,int errorKey, int lockKey) {
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(outKey);
		ids.add(errorKey);
		ids.add(lockKey);
		return this.dictionaryService.queryDictionaryInIds(ids);
	}
}
