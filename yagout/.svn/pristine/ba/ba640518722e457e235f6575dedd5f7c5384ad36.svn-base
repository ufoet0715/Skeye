package com.skeye.yagout.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DateFormatUtil {
	public static String toDateStringM(long time)
    {
    	GregorianCalendar gc = new GregorianCalendar(); 
        gc.setTimeInMillis(time * 1000);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return simpleDateFormat.format(gc.getTime());
    }
	
    public static String toDateStringS(long time)
    {
    	GregorianCalendar gc = new GregorianCalendar(); 
        gc.setTimeInMillis(time * 1000);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(gc.getTime());
    }
}
