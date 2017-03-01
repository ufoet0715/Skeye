package com.yagout.defense.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getStrByDate(Date date,String formatstr){
		String str="";
		SimpleDateFormat dateformat=new SimpleDateFormat(formatstr);
		if(date!=null){
			str= dateformat.format(date);
		}
			return str;
	}
	
	public static Long  getDateByStr(String datestr,String formatstr){

		Long time=null;
		try {
			SimpleDateFormat dateformate=new SimpleDateFormat(formatstr);
			Date	date=dateformate.parse(datestr);
			time=date.getTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	public static String getFileNameByDate(String ext){
		Date today=new Date();
		String datestr=getStrByDate(today, "yyyyMMddHH");
		
		for(int i=0;i<4;i++){
			int num=(int)(Math.random()*10);
			datestr=datestr+num;
		}
		return datestr+"."+ext;
	}
	
	public static String getFileName(String xslx){
		String datestr = null;
		for(int i=0;i<4;i++){
			int num=(int)(Math.random()*3);
			datestr=datestr+num;
		}
		return datestr+"."+xslx;
	}
	
	
	public static String getFileNameByDate(){
		Date today=new Date();
		String datestr=getStrByDate(today, "MMdd");
		
		for(int i=0;i<6;i++){
			int num=(int)(Math.random()*4);
			datestr=datestr+num;
		}
		return datestr;
	}

}
