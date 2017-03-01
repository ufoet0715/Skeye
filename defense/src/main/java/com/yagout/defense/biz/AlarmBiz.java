package com.yagout.defense.biz;

import com.yagout.defense.dal.model.StrategyKey;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public interface AlarmBiz {

	void  queryAlarmsByPage(CommonPage commonPage);
	
	CommonResult updateFlagById(Map<String,Object> map);

	CommonResult deleteStrategies(List<Integer> strategiesIds);
	
	CommonResult insertStrategy(List<StrategyKey> strategies);
	
	List<Map<String, Object>> queryStrategiesByAlarm(Integer invadeId);
	
	List<Map<String, Object>> queryDefaultStrategiesByAlarm(Integer invadeId);

	CommonResult updateStrategy(Map<String,Object> map);


	void report(ModelAndView view);

	byte[] reportDown( ) throws Exception;

}
