package com.yagout.defense.controller;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.MacManegerBiz;
import com.yagout.defense.biz.StationBiz;
import com.yagout.defense.biz.bean.*;
import com.yagout.defense.dal.model.ExceptionMac;
import com.yagout.defense.dal.model.Station;
import com.yagout.defense.dal.model.StationAdapter;
import com.yagout.defense.service.ApService;
import com.yagout.defense.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/stationTrust")
public class StationTrustController {
	private final MacType MAC_TYPE = MacType.STATION_TRUST;
	@Autowired
	private MacManegerBiz macManegerBiz;
	@Autowired private StationBiz stationBiz;
	@Autowired private ApService apService;
	
	@Value("${defaultPwd}")
	@Autowired
	private String defaultPwd;

	@RequestMapping("/stationTrustList")
	public String list() {
		return "stationTrust/stationTrustList";
	}

	@RequestMapping("/stationTrustListData")
	@ResponseBody
	public String stationTrustListData(CommonPage commonPage) {
		macManegerBiz.queryByPage(commonPage, this.MAC_TYPE);
		return commonPage.toShowPage();
	}

	@RequestMapping(value = "/deleteStationTrusts")
	@ResponseBody
	public String deleteUsers(@RequestBody List<String> args) {
		CommonResult result = macManegerBiz.batchDelete(args, this.MAC_TYPE);
		return JSONObject.toJSONString(result);
	}
	
	@RequestMapping(value = "/{url}/add")
	public ModelAndView addFrom(@PathVariable(value = "url")String url){
		ModelAndView view = new ModelAndView("stationTrust/stationTrustEdit");
		if("syap".equals(url)){
			url = "xzap";
		}else if("syzd".equals(url)){
			url = "bhzd";
		}
		view.addObject("urlName", url);
		view.addObject("oper", "'add'");
		return view;
	}
	
	@RequestMapping(value = "/{url}/edit")
	public ModelAndView editFrom(@RequestParam(value = "mac")String mac,@PathVariable(value = "url")String url){
		ModelAndView view = new ModelAndView("stationTrust/stationTrustEdit");
		if("xzap".equals(url)){
			view.addObject("dataBean", apService.query(mac, "ap_trust"));
		}else if("ljap".equals(url)){
			view.addObject("dataBean", apService.query(mac, "ap_neighbor"));
		}else if("fkap".equals(url)){
			view.addObject("dataBean", apService.query(mac, "ap_visitor"));
		}else if("zzwap".equals(url)){
			view.addObject("dataBean", apService.query(mac, "ap_ad_hoc"));
		}else if("mac".equals(url)){
			view.addObject("dataBean", apService.query(mac, "exception_mac"));
		}else if("bhzd".equals(url)){
			view.addObject("dataBean", apService.query(mac, "station_trust"));
		}else if("ljzd".equals(url)){
			view.addObject("dataBean", apService.query(mac, "station_neighbor"));
		}else if("fkzd".equals(url)){
			view.addObject("dataBean", apService.query(mac, "station_visitor"));
		}else if("zzwzd".equals(url)){
			view.addObject("dataBean", apService.query(mac, "station_ad_hoc"));
		}else if("syap".equals(url)){
			view.addObject("dataBean", apService.query(mac, "scan_ap"));
			url = "xzap";
		}else if("syzd".equals(url)){
			view.addObject("dataBean", apService.query(mac, "scan_station"));
			url = "bhzd";
		}
		view.addObject("urlName", url);
		view.addObject("oper", "'edit'");
		return view;
	}

	@RequestMapping(value = "/getMacAddress",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMacAddress(String mac){
		Map<String, String> map = stationBiz.queryAllByMac(mac);
		String tableName = null;
		if(map != null && map.size()>0){
			tableName = map.get("tableName");
		}
		return tableName;
	}

	/*@RequestMapping(value = "/getMacData")
	@ResponseBody
	public List<Object> getMacData(@RequestParam(value = "urlName")String urlName){
		List<Object> list = new ArrayList<Object>();
		if("xzap".equals(urlName) || "ljap".equals(urlName) || "fkap".equals(urlName) || "zzwap".equals(urlName)){
			List<ScanAp> apList = scanApBiz.queryApList();
			for (ScanAp scanAp : apList) {
				list.add(scanAp);
			}
		}else if("mac".equals(urlName)){
			List<ExceptionMacBean> exList = exceptionMacBiz.queryList();
			for (ExceptionMacBean exceptionMacBean : exList) {
				list.add(exceptionMacBean);
			}
		}else if("bhzd".equals(urlName) || "ljzd".equals(urlName) || "fkzd".equals(urlName) || "zzwzd".equals(urlName)){
			List<ScanStation> stationList = scanStationBiz.queryStationList();
			for (ScanStation scanStation : stationList) {
				list.add(scanStation);
			}
		}
		return list;
	}*/
	
	@RequestMapping(value = "/addsave")
	@ResponseBody
	public CommonResult addsave(@RequestBody Map<String, String> map){
		List<Station> stations = new ArrayList<Station>();
		List<String> sqlList = null;
		boolean success = false;
		Station station = null;
		Map<String, Object> data = null;
		List<Map<String, Object>> datamap = null;
		List<String> delList = new ArrayList<String>();
		StationAdapter stationAdapter=new StationAdapter();
		for (String in : map.keySet()) {
			if(StringUtils.isEmpty(map.get(in))){
				delList.add(in);
			}else{
				data = new HashMap<String, Object>();
				//map.keySet()返回的是所有key的值
				String str = map.get(in);//得到每个key多对用value的值
				data = CRequest.URLRequest(str);
				data.put("pwd", defaultPwd);
				if("xzap".equals(data.get("macType"))){
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new ApTrustBean(), data));
					sqlList = ObjectUtil.ObjectToSql(new ApTrustBean(),data);
					station.setTableName("ap_trust");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addApNum();
				}else if("ljap".equals(data.get("macType"))){
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new ApNeighborBean(), data));
					sqlList = ObjectUtil.ObjectToSql(new ApNeighborBean(),data);
					station.setTableName("ap_neighbor");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addApNum();
				}else if("fkap".equals(data.get("macType"))){
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new ApVisitorBean(), data));
					sqlList = ObjectUtil.ObjectToSql(new ApVisitorBean(),data);
					station.setTableName("ap_visitor");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addApNum();
				}else if("zzwap".equals(data.get("macType"))){
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new ApAdHocBean(), data));
					sqlList = ObjectUtil.ObjectToSql(new ApAdHocBean(),data);
					station.setTableName("ap_ad_hoc");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addApNum();
				}else if("mac".equals(data.get("macType"))){
					Long createTime = new Date().getTime();
					String cnvalidTimeStr = (String) data.get("cnvalidTimeBean");
					String timeStr = cnvalidTimeStr.replace("+", " ");
					Long cnvalidTime = DateUtils.getDateByStr(timeStr, "yyyy-MM-dd HH:mm:ss");
					if(createTime>cnvalidTime){
						data.put("excpState", 0);
					}else{
						data.put("excpState", 1);
					}
					data.put("createTime", createTime);
					data.put("cnvalidTime", cnvalidTime);
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new ExceptionMac(), data));
					sqlList = ObjectUtil.ObjectToSql(new ExceptionMac(), data);
					station.setTableName("exception_mac");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addMacNum();
				}else if("bhzd".equals(data.get("macType"))){
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new StationTrustBean(), data));
					sqlList = ObjectUtil.ObjectToSql(new StationTrustBean(),data);
					station.setTableName("station_trust");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addClientNum();
				}else if("ljzd".equals(data.get("macType"))){
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new StationNeighborBean(), data));
					sqlList = ObjectUtil.ObjectToSql(new StationNeighborBean(),data);
					station.setTableName("station_neighbor");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addClientNum();
				}else if("fkzd".equals(data.get("macType"))){
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new StationVisitorBean(), data));
					sqlList = ObjectUtil.ObjectToSql(new StationVisitorBean(),data);
					station.setTableName("station_visitor");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addClientNum();
				}else if("zzwzd".equals(data.get("macType"))){
					station = new Station();
					datamap = new ArrayList<Map<String,Object>>();
					datamap.add(ObjectUtil.FormatMap(new StationAdHocBean(), data));
					sqlList = ObjectUtil.ObjectToSql(new StationAdHocBean(),data);
					station.setTableName("station_ad_hoc");
					station.setData(datamap);
					station.setDbData(sqlList);
					stations.add(station);
					stationAdapter.addClientNum();
				}
			}
		}
		List<Station> delStations = new ArrayList<Station>();
		Station stationDel = new Station();
		List<Map<String, Object>> delListMap = new ArrayList<Map<String,Object>>(); 
		Map<String, Object> delMap;
		for (String string : delList) {
			delMap = new HashMap<String, Object>();
			delMap.put("mac", string);
			delListMap.add(delMap);
		}
		stationDel.setData(delListMap);
		delStations.add(stationDel);
		if(stationDel.getData().size()>0){
			success = this.stationBiz.update(delStations, stationAdapter);
		} 
		if(stations.size()>0){
			success = this.stationBiz.update(stations,stationAdapter);
		}
		return new CommonResult(success);
	}

	@RequestMapping(value = "/stationTrustEdit", produces = "text/html; charset=utf-8")
	public ModelAndView stationTrustEdit(
			@RequestParam(value = "data", required = false) String mac) {
		ModelAndView view = new ModelAndView("stationTrust/stationTrustEdit");
		Map<String, Object> model = new HashMap<String, Object>();
		if (mac != null) {
			// 修改操作
			StationTrustBean stationTrustBean = (StationTrustBean) ObjectUtil
					.transfer(
							macManegerBiz.queryByPrimaryKey(mac, this.MAC_TYPE),
							StationTrustBean.class);
			if (stationTrustBean == null) {
				model.put("noDataToFind", true);
			} else {
				model.put("stationTrustBean", stationTrustBean);
			}
		}
		return view;
	}

	@RequestMapping("/stationTrustSave")
	@ResponseBody
	public boolean stationTrustSave(@SuppressWarnings("rawtypes") Map pageData) {
		if (pageData == null) {
			return false;
		}
		if ("add".equals(pageData.get("action"))) {
			return true;
		} else {
			System.out.println(pageData);
		}
		return false;
	}
}
