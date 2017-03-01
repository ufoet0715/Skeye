package com.yagout.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yagout.BasicTest;
import com.yagout.JUnit4ClassRunner;
import com.yagout.defense.dal.dao.ApDao;
import com.yagout.defense.dal.dao.ApTrustDao;
import com.yagout.defense.dal.dao.StationDao;
import com.yagout.defense.dal.model.Ap;
import com.yagout.defense.dal.model.ApTrust;
import com.yagout.defense.dal.model.Station;
public class ApTrustDaoTest extends BasicTest{

	 @Autowired  private ApTrustDao apTrustDao;
	 @Autowired
	 private ApDao apDao;
	 @Autowired
	 private StationDao stationDao;

	    @Test
	    public  void  test(){
	    	
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	List<String> list = new ArrayList<String>();
	    	list.add("mac");
	    	list.add("name");
	    	list.add("id_number");
	    	Map<String, Object> alias = new HashMap<String, Object>();
	    	alias.put("mac","mac");
	    	alias.put("name","name");
	    	alias.put("idNumber","id_number");
	    	map.put("mac", 1);
	    	map.put("tableName", "station_visitor");
	    	map.put("list", list);
	    	map.put("alias", alias);
	    	System.out.println(stationDao.queryByMac(map));
	    	//添加
	    	/*List<Station> stationList = new ArrayList<Station>();
	    	Station station= new Station();
	    	station.setTableName("station_visitor");
	    	Map<String, Object> data = new LinkedHashMap<String, Object>();
	    	data.put("mac", "1");
	    	data.put("maker", "2");
	    	data.put("name", "7");
	    	data.put("phoneNumber", "4");
	    	data.put("idNumber", "8");
	    	//data.put("department", "2");
	    	data.put("remarks", "6");
	    	List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	    	list.add(data);
	    	List<String> str  = new ArrayList<String>();
	    	str.add("mac");
	    	str.add("maker");
	    	str.add("name");
	    	str.add("phone_number");
	    	str.add("id_number");
	    	//str.add("department");
	    	str.add("remarks");
	    	station.setData(list);
	    	station.setDbData(str);
	    	stationList.add(station);
	    	stationDao.updateStations(stationList);*/
	    	
	    	
	    	
	    	//批量添加
	    	/*List<ApTrust> apTrustList = new ArrayList<ApTrust>();
	    	for(int i = 0;i<2;i++){
		    	ApTrust apTrust = new ApTrust();
		    	apTrust.setMac(""+i);
		    	apTrust.setBeacon("111");
		    	apTrust.setBeaconSize(2);
		    	apTrust.setMaker("111");
		    	apTrust.setPrivacy(1);
		    	apTrust.setProbeResponse("11");
		    	apTrust.setProbeResponseSize(11);
		    	apTrust.setPwd("12");
		    	apTrust.setRemarks("a");
		    	apTrust.setSsid("123");
		    	apTrustList.add(apTrust);
	    	}
	        apTrustDao.saveApTrusts(apTrustList);*/
	    	
	    	
	    	//根据mac查询
	    	//System.out.println(apTrustDao.queryByMac("1").getPwd());
	    	
	    	//查询全部
	    	//System.out.println(apTrustDao.getApTrustByMap(null));
	    	//批量删除
	    	/*List<String> macs = new ArrayList<String>();
	    	macs.add("0");
	    	macs.add("1");
	    	apTrustDao.deleteApTrusts(macs);*/
	    	
	    	
	    	//批量修改
	    	/*List<ApTrust> apTrustList = new ArrayList<ApTrust>();
	    	for(int i = 0;i<2;i++){
		    	ApTrust apTrust = new ApTrust();
		    	apTrust.setMac(""+i);
		    	apTrust.setBeacon("121");
		    	apTrust.setBeaconSize(1);
		    	apTrust.setMaker("12");
		    	apTrust.setPrivacy(3);
		    	apTrust.setProbeResponse("14");
		    	apTrust.setProbeResponseSize(8);
		    	apTrust.setPwd("11");
		    	apTrust.setRemarks("2");
		    	apTrust.setSsid("133");
		    	apTrustList.add(apTrust);
	    	}
	    	apTrustDao.updateApTrusts(apTrustList);*/
	    }
	
}
