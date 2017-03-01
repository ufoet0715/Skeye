package com.yagout.defense.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;

import com.yagout.defense.redis.RedisCache;
import com.yagout.defense.util.CommonResult;

/**
 * 
 * @author SCJ
 * 验证码生成器
 */
@Controller
@RequestMapping("/kaptchaImageController")
public class KaptchaImageController {
    @Autowired private RedisCache<String, String> redisCache;

    /**
     * 设置背景图片格式
     */
    public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";

    
    private Properties properties = new Properties();
    private Producer kaptchaProducer = null;    
    
    /**
     * 初始化KaptchaImageController
     * 设置验证码生成器的样式
     */
	public KaptchaImageController() {
		ImageIO.setUseCache(false);
		
		this.properties.put(Constants.KAPTCHA_IMAGE_WIDTH, "200");
		this.properties.put(Constants.KAPTCHA_IMAGE_HEIGHT, "60");
		this.properties.put(Constants.KAPTCHA_BORDER, "no");
		this.properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
		this.properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "5");
		this.properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "40");
		
		Config config=new Config(this.properties);
		this.kaptchaProducer=config.getProducerImpl();
	}
    
	/**
	 * 生成验证码生成器的背景图片和验证码
	 * 把验证码存入redis缓存中
	 * @param codeType
	 * @param request
	 * @param response
	 * @throws IOException
	 */
    @RequestMapping("/getKaptchaImage")
    public void getKaptchaImage(@RequestParam("codeType") String codeType,HttpServletRequest request,HttpServletResponse response) 
    		throws IOException{
    	HttpSession session = request.getSession();
    	response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/" + CAPTCHA_IMAGE_FORMAT);
        
        String createText = this.kaptchaProducer.createText();
        BufferedImage bi=this.kaptchaProducer.createImage(createText);
        
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(bi, CAPTCHA_IMAGE_FORMAT, os);
        redisCache.put(session.getId()+codeType+Constants.KAPTCHA_SESSION_KEY, createText);
    }
    
    /**
     * 验证输入的验证码
     * @param request
     * @param codeType
     * @param mCode
     * @return
     */
    @RequestMapping("/checkBody")
    @ResponseBody
    public String checkBody(HttpServletRequest request,@RequestParam("codeType") String codeType,@RequestParam("mCode") String mCode){
		HttpSession session=request.getSession();
		
		String createText = redisCache.get(session.getId()+codeType+Constants.KAPTCHA_SESSION_KEY);
		
		CommonResult commonResult=new CommonResult();
		
		if(mCode.equals(createText)||createText==null)
		{
				commonResult.setIsSuccess(true);
		}
		else
		{
			commonResult.setResultMsg("验证码不正确！");
		}
		
    	return JSONObject.toJSONString(commonResult);
    } 
}
