package com.skeye.yagout.util;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.DateTool;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

/**
 * Created by Skeyedu on 2016/11/17.
 */
public class VelocityUtil {

     private static DateTool dateTool=new DateTool();
    private static    VelocityConfigurer velocityConfigurer;

    public   VelocityConfigurer getVelocityConfigurer() {
        return velocityConfigurer;
    }

    public   void setVelocityConfigurer(VelocityConfigurer velocityConfigurer) {
        VelocityUtil.velocityConfigurer = velocityConfigurer;
    }

    public  static VelocityEngine getConfigurer() {
        return velocityConfigurer.getVelocityEngine();
    }


    public static DateTool getDateTool(){
        return   dateTool;
    }
}
