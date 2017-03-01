package com.yagout.defense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yagout.defense.biz.StationAdHocBiz;
import com.yagout.defense.biz.StationNeighborBiz;
import com.yagout.defense.biz.StationTrustBiz;
import com.yagout.defense.biz.StationVisitorBiz;
import com.yagout.defense.util.CommonPage;

@Controller
@RequestMapping("/allstation")
public class AllStationController {
	
	@Autowired private StationAdHocBiz adBiz;
	@Autowired private StationVisitorBiz visiBiz;
	@Autowired private StationNeighborBiz neiBiz;
	@Autowired private StationTrustBiz trBiz;
	
	@RequestMapping("/allstationList")
    public String userList() {
        return "stationTrust/allstationList";
    }
	
	@RequestMapping(value="/{value}/allstationListData")
	@ResponseBody
    public String scan_apListData(CommonPage commonPage,@PathVariable(value = "value")String value) {
		if(value.equals("stationNeighbor")){
			neiBiz.queryByMap(commonPage);
		}else if(value.equals("statinTrust")){
			trBiz.queryByMap(commonPage);
		}else if(value.equals("stationVisitor")){
			visiBiz.queryByMap(commonPage);
		}else if(value.equals("stationAdHoc")){
			adBiz.queryByMap(commonPage);
		}else{
			
		}
		
		return commonPage.toShowPage();
    }

}
