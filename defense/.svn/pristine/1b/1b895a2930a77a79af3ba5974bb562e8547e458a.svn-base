package com.yagout.defense.util;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {  
  
    @Override  
    public String print(Date object, Locale locale) {  
        return null;  
    }  
  
    @Override  //如果controller接收的数据对象中有属性是Date类型，那么springMVC就会拦截访问这个controller的所有请求
    public Date parse(String text, Locale locale) throws ParseException  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置一个时间格式
        Date date = null;//定义一个时间对象
        try {
            date = format.parse(text);//将接收到的字符串通过SimpleDateFormat.parse转换成的对应格式的时间对象
        } catch (Exception e) {  
            format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.parse(text);
        }  
        return date;//将转化之后的时间对象返回到springMVC拦截的请求中传给controller，执行后续操作
    }  
  
    public static String dateFormat(Date date)
    {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return format.format(date);
    }
    
    public static Date stringParse(String dateStr)
    {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date=null;
    	try {
    		date= format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return date;
    }
}  