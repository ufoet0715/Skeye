package com.yagout.defense.biz;


import org.springframework.web.multipart.MultipartFile;

import com.yagout.defense.util.CommonResult;




public interface UpdateBiz {



	public CommonResult uploadUpdate(MultipartFile myfile);
	
	public CommonResult save(String name);
	
	public CommonResult sqlUpdate(MultipartFile myfile);
   

}
