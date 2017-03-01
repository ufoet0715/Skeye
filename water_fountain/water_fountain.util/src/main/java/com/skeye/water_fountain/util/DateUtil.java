package com.skeye.water_fountain.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static String DATE_FORMAT = "yyyy-MM-dd";
	private static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String setDateToString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		return simpleDateFormat.format(date);
	}

	public static Date setStringToDate(String date) {
		Date out = Calendar.getInstance().getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			out = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return out;
	}
	
	public static String setTimeToString(Date date)
	{
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(TIME_FORMAT);
		return simpleDateFormat.format(date);
	}
	
	public static Date setStringToTime(String date)
	{
		Date out=Calendar.getInstance().getTime();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(TIME_FORMAT);
		try {
			out=simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return out;
	}
}
