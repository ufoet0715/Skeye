package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.StationBiz;
import com.yagout.defense.dal.model.Station;
import com.yagout.defense.dal.model.StationAdapter;
import com.yagout.defense.service.StationService;
import com.yagout.defense.service.UserLogService;
import com.yagout.defense.util.LogTypeEnum;

@Service
public class StationBizImpl implements StationBiz {
    
	@Autowired private StationService stationService;
	@Autowired private UserLogService userLogService;
	
	@Override
	public boolean update(List<Station> stationList,StationAdapter stationAdapter) {
		boolean result=false;
		try {
			result=this.stationService.update(stationList);
			if(result)
			{
				insertUserLogCriteria(result, "", stationAdapter);
			}
			else
			{
				insertUserLogCriteria(result, "数据更新失败！", stationAdapter);
			}
		} catch (Exception e) {
			// TODO: handle exception
			insertUserLogCriteria(result, "操作异常！", stationAdapter);
		}
		return result;
	}

	private void insertUserLogCriteria(boolean result,String exception,StationAdapter stationAdapter){
		if(stationAdapter.getSetApNum()>0)
		{
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_SET_AP, result, exception);
		}
		if(stationAdapter.getSetClientNum()>0)
		{
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_SET_CLIENT, result, exception);
		}
		if(stationAdapter.getSetMacNum()>0)
		{
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_IGNORE_MAC, result, exception);
		}
	}
	
	public Map<String, String> queryAllByMac(String mac){
		try {
			return stationService.queryAllByMac(mac);
		} catch (Exception e) {
			System.out.println("mac查询位置异常");
			return null;
		}
	}
}
