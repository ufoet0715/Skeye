package com.yagout.defense.biz.impl;

import com.yagout.defense.biz.UpdateBiz;
import com.yagout.defense.biz.bean.SoketBean;
import com.yagout.defense.biz.bean.UpdateBean;
import com.yagout.defense.service.SokectSendService;
import com.yagout.defense.service.UpdateService;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.FileUtils;
import com.yagout.defense.util.SoketEnum;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Skeyedu on 2017/2/13.
 */
@Service
public class UpdateBizImpl implements UpdateBiz {
	@Value("${outPutPath}")
	private String outPutPath;
	@Autowired
	UpdateService updateService;
	private static Logger logger = Logger.getLogger(UpdateBiz.class);

	@Autowired
	private SokectSendService sokectSendService;
	
	public CommonResult sqlUpdate(MultipartFile myfile){
		CommonResult result = new CommonResult();
		try {
			String sql = FileUtils.readTxtFile(myfile.getInputStream());
			updateService.sqlUpdate(sql);
			result.setIsSuccess(true);
		} catch (Exception e) {
			result.setResultMsg("策略升级异常");
		}
		return result;
	}

	@Override
	public CommonResult uploadUpdate(MultipartFile myfile) {
		CommonResult result = new CommonResult();

		UpdateBean updateBean = new UpdateBean();
		try {

			if (myfile.isEmpty()) {
				result.setResultMsg("上传文件不能为空");

			} else {
				String originalFilename = myfile.getOriginalFilename();// 得到文件名字

				if (originalFilename.indexOf(".zip") >= 0) {
					originalFilename = DateFormatUtils.format(new Date(), "yyMMddhhmm") + originalFilename;
					FileUtils.upload(myfile.getInputStream(), outPutPath, originalFilename);
					// coding
					result.setIsSuccess(true);

					updateBean.setFileName(originalFilename);
					updateBean.setIniText(FileUtils.readZipFile(outPutPath + "\\" + originalFilename));

					result.setIsSuccess(true);
					result.setData(updateBean);
				} 

			}
			

		} catch (Exception e) {
			result.setResultMsg("上传文件异常");
		}
		return result;
	}

	/**
	 * 升级保存后 升级通知
	 * 
	 * @param name
	 * @return
	 */
	public CommonResult save(String name) {
		CommonResult commonResult = new CommonResult();
		try {
			SoketBean soketBean = new SoketBean();
			soketBean.setSoketEnum(SoketEnum.UPGRADE_DEVICE);
			soketBean.setData(name);
			soketBean.setTime(new Date());
			soketBean.setNo(UUID.randomUUID().toString());
			commonResult = sokectSendService.sendData(soketBean);
		} catch (Exception e) {
			logger.error("系统升级异常", e);
		}
		return commonResult;

	}

}
