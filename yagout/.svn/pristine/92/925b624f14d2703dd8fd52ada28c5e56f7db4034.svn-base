package com.skeye.yagout.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import com.skeye.yagout.shiro.RedisCache;
import com.skeye.yagout.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Properties;

/**
 * Created by Skeyedu on 2016/11/16.
 */
@Controller
@RequestMapping("kaptcha")
public class KaptchaImageController {


    @Autowired
    private Producer captchaProducer;
    @Autowired
    private RedisCache<String, String> redisCache;

    public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";

    //--kapcha验证码。
    private Properties props = new Properties();
    private Producer kaptchaProducer = null;

    public  KaptchaImageController(){
        ImageIO.setUseCache(false);

        //设置宽和高。
        this.props.put(Constants.KAPTCHA_IMAGE_WIDTH, "200");
        this.props.put(Constants.KAPTCHA_IMAGE_HEIGHT, "60");
        //kaptcha.border：是否显示边框。
        this.props.put(Constants.KAPTCHA_BORDER, "no");
        //kaptcha.textproducer.font.color：字体颜色
        this.props.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
        //kaptcha.textproducer.char.space：字符间距
        this.props.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "5");
        //设置字体。
        this.props.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "40");
        //this.props.put(Constants.KAPTCHA_NOISE_COLOR, "");
        //更多的属性设置可以在com.google.code.kaptcha.Constants类中找到。
        Config config1 = new Config(this.props);
        this.kaptchaProducer = config1.getProducerImpl();


    }





    @RequestMapping("getKaptchaImage")
    public void getKaptchaImage(@RequestParam("codeType") String codeType, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/" + CAPTCHA_IMAGE_FORMAT);

        String capText = this.kaptchaProducer.createText();
        BufferedImage bi = this.kaptchaProducer.createImage(capText);

        ServletOutputStream out = response.getOutputStream();

        ImageIO.write(bi, CAPTCHA_IMAGE_FORMAT, out);
        redisCache.put(session.getId()+codeType+Constants.KAPTCHA_SESSION_KEY,capText);

    }


    @RequestMapping(value="checkmCode", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String checkCode(HttpServletRequest request,@RequestParam("codeType")String codeType,@RequestParam("mcode")String mcode){
        HttpSession session = request.getSession();
        String code=redisCache.get(session.getId()+codeType+Constants.KAPTCHA_SESSION_KEY);
        CommonResult result=new CommonResult();
        if (mcode.equals(code)) {
            result.setIsSuccess(true);
        }else {
            result.setResultMsg("验证码不正确");
        }
        return JSONObject.toJSONString(result);
    }
}
