package com.skeye.yagout.biz.impl;

import com.skeye.yagout.biz.AnalysisBiz;
import com.skeye.yagout.biz.enumpackage.AnalysisTypeEnum;
import com.skeye.yagout.dal.model.RawaccountHandledAndAccountType;
import com.skeye.yagout.service.AnalysisService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/11/19.
 */
@Service
public class AnalysisBizImpl implements AnalysisBiz {
    @Autowired
    private AnalysisService analysisService;
    private static Logger logger = Logger.getLogger(AnalysisBizImpl.class);

    @Override
    public Map<String, Object> accountType(Long beginTime, Long endTime) {
        Map<String, Object> map = new HashMap();
        List<String> legend = new ArrayList<String>();
        List<Map<String, Object>> series = new ArrayList<Map<String, Object>>();
        map.put("legend", legend);
        map.put("series", series);
        try {
            List<RawaccountHandledAndAccountType> data = analysisService.countByNameAndType(beginTime, endTime);
            if (data != null && data.size() > 0) {

                Map<String, Object> tempSerie;
                for (RawaccountHandledAndAccountType tmpData : data) {
                    legend.add(tmpData.getTypeName());
                    tempSerie = new HashMap<String, Object>();
                    tempSerie.put("name", tmpData.getTypeName());
                    tempSerie.put("value", tmpData.getCount());
                    tempSerie.put("id", tmpData.getAccountType());
                    tempSerie.put("analysisType", AnalysisTypeEnum.ACCOUNT_TYPE.getMsg());
                    series.add(tempSerie);
                }
            }
        } catch (Exception e) {
            logger.error("账户类型分析异常", e);
        }
        return map;
    }

    public Map<String, Object> accountOther(Long beginTime, Long endTime, Integer analysisType) {
        Map<String, Object> map = new HashMap();
        List<String> legend = new ArrayList<String>();
        List<Map<String, Object>> series = new ArrayList<Map<String, Object>>();
        map.put("legend", legend);
        map.put("series", series);
        try {


            AnalysisTypeEnum typeEnum = AnalysisTypeEnum.find(analysisType);
            if (typeEnum == null) return null;
            List<RawaccountHandledAndAccountType> data = null;
            switch (typeEnum) {
                case IP:
                    data = analysisService.countByNameAndIP(beginTime, endTime);
                    break;
                case ADSL:
                    data = analysisService.countByNameAndADSL(beginTime, endTime);
                    break;
                case MAC:
                    data = analysisService.countByNameAndMAC(beginTime, endTime);
                    break;
            }
            if (data != null && data.size() > 0) {
                Map<String, Object> tempSerie;
                for (RawaccountHandledAndAccountType tmpData : data) {
                    tempSerie = new HashMap<String, Object>();
                    tempSerie.put("analysisType", typeEnum.getMsg());
                    switch (typeEnum) {
                        case IP:
                            legend.add(tmpData.getIpAddr());
                            tempSerie.put("name", tmpData.getIpAddr());
                            break;
                        case ADSL:
                            legend.add(tmpData.getAdslAccount());
                            tempSerie.put("name", tmpData.getAdslAccount());
                            break;
                        case MAC:
                            legend.add(tmpData.getMacAddr());
                            tempSerie.put("name", tmpData.getMacAddr());
                            break;
                    }
                    tempSerie.put("value", tmpData.getCount());
                    tempSerie.put("id", tempSerie.get("name"));
                    series.add(tempSerie);
                }

            }
        } catch (Exception e) {
            logger.error("账户ADSL或MAC分析异常", e);
        }
        return map;
    }

    @Override
    public Map<String, Object> timeAnalysis(String beginTime, String endTime, String accountName, String adslAccountEq, String timeFmort) {
        Map<String, Object> map = new HashMap();
        List<String> legend = new ArrayList<String>();
        Map<String, Object> series = new HashMap<String, Object>();
        List<String> xAxis=new  ArrayList<String>();
        map.put("legend", legend);
        map.put("series", series);
        map.put("xAxis", xAxis);
        String  lengendStr="轨迹次数统计";
        try {
            if(StringUtils.isNotEmpty(accountName)){
                legend.add("account帐号为"+accountName+"的"+lengendStr);
            }
            if(StringUtils.isNotEmpty(adslAccountEq)){
                legend.add("adsl帐号为"+adslAccountEq+"的"+lengendStr);
            }
            if (legend.size()==0){
                legend.add(lengendStr);
            }
            List<Integer> serieData = new ArrayList<Integer>();
            series.put("data",serieData);
            series.put("name",legend.get(0));
            List<RawaccountHandledAndAccountType> data = analysisService.countByTime(beginTime, endTime, accountName, adslAccountEq, timeFmort);
            if (data != null && data.size() > 0) {
                for (RawaccountHandledAndAccountType tmpData : data) {
                    xAxis.add(tmpData.getTimeShow());
                    serieData.add(tmpData.getCount());
                }
            }
        } catch (Exception e) {
            logger.error("柱状图查询异常", e);
        }
        return map;
    }
}
