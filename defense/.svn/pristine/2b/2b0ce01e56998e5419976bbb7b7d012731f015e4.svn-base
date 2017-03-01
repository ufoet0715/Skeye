package com.yagout.defense.biz.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.DeviceMonitorBiz;
import com.yagout.defense.biz.bean.DeviceMonitorBean;
import com.yagout.defense.dal.model.DeviceMonitor;
import com.yagout.defense.redis.RedisCache;
import com.yagout.defense.service.DeviceMonitorService;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.ObjectUtil;

@Service
public class DeviceMonitorBizImpl implements DeviceMonitorBiz {
	private static Logger logger = Logger.getLogger(DeviceMonitorBizImpl.class);
	public static final String DEVICELIST = "deviceList";
	@Autowired
	private DeviceMonitorService demtservice;
	@Autowired
	private RedisCache<String, Object> redisCache;

	@SuppressWarnings("null")
	@Override
	public CommonResult updateDeviceMonitor(DeviceMonitorBean bean) {
		CommonResult result = new CommonResult();
		DeviceMonitor demt = null;
		try {
			if (bean != null) {
				demt = demtservice.getDemtById(bean.getDeviceSerial());
			} else {
				if (StringUtils.isNotEmpty(bean.getName())) {
					demt = demtservice.getDemtByName(bean.getName());
				}
			}
			if (demt == null) {
				return new CommonResult(false, "设备未找到！");
			}
			demt.setRemarks(bean.getRemarks());
			result.setIsSuccess(demtservice.updateDeviceMonitor(demt));
			result.setData(demt.getName());
			if (demtservice.updateDeviceMonitor(demt)) {
				clear();
			}
		} catch (Exception e) {
			logger.error("修改设备备注异常！");
		}

		return result;
	}

	private void clear() {
		redisCache.remove(DEVICELIST);
	}

	@Override
	public DeviceMonitor getDeviceMonitorById(String deviceSerial) {
		DeviceMonitor demt = demtservice.getDemtById(deviceSerial);
		return demt;
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<DeviceMonitorBean> queryAllDeviceMonitor() {
		List<DeviceMonitorBean> datas = null;
		try {
			datas = (List<DeviceMonitorBean>) redisCache.get(DEVICELIST);
			if (datas == null || datas.size() == 0) {
				List<DeviceMonitor> demts = demtservice.selAllDeviceMonitor();
				if (demts != null || demts.size() > 0) {
					datas = ObjectUtil.transferList(demts, DeviceMonitorBean.class);
					redisCache.put(DEVICELIST, datas,50000);
				}
			}
		} catch (Exception e) {
			System.out.println("查询异常");
		}
		return datas;
	}
}
