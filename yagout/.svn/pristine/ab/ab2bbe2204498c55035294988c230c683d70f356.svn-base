package com.skeye.yagout.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;

public class ObjectUtil {
	private static Logger logger = Logger.getLogger(ObjectUtil.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object transfer(Object from, Class targetClass) {
		if (from == null)
			return null;
		
	
		try {
			Object target = targetClass.newInstance();// 创建实例 类似new出一个目标对象
			Field[] targetFields = targetClass.getDeclaredFields();// 目标对象类型的属性数组
			Method fromMethod = null;
			Method targetMethod = null;
			Object data;// 属性值
			String methodFiled = null;
			for (Field targetField : targetFields) {
				try {
					fromMethod = null;
					methodFiled = getBig(targetField.getName());
					fromMethod = from.getClass().getDeclaredMethod("get" // 根据
																			// 目标属性获取来源对象get属性的方法
							+ methodFiled);
				} catch (Exception e) {
					logger.info("转换类型获取方法异常" + targetField.getName(), e);
				}
				if (fromMethod == null)
					continue;
				data = fromMethod.invoke(from);// 调用来源对象的get方法获取值
				try {
					targetMethod = null;
					targetMethod = targetClass.getDeclaredMethod("set" + methodFiled, data.getClass());

				} catch (Exception e) {
					logger.info("转换类型存放方法异常" + targetField.getName(), e);
				}
				if (targetMethod != null)
					targetMethod.invoke(target, data);// 目标对象调用set方法
			}

			return target;
		} catch (Exception e) {
			logger.error("转换类型异常", e);
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object transfer(Map<String, Object> from, Class targetClass) {
		if (from == null || from.size() == 0)
			return null;
		try {
			Object target = targetClass.newInstance();
			Method targetMethod = null;
			for (Map.Entry<String, Object> entry : from.entrySet()) {
				try {
					targetMethod = null;
					targetMethod = targetClass.getDeclaredMethod("set" + getBig(entry.getKey()),
							entry.getValue().getClass());
				} catch (Exception e) {
					logger.info("转换类型存放方法异常" + entry.getKey(), e);
				}
				if (targetMethod != null)
					targetMethod.invoke(target, entry.getValue());
			}
			return target;
		} catch (Exception e) {
			logger.error("转换类型异常", e);
			return null;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List transferListMap(List<Map> from, Class targetClass) {
		if (from == null || from.size() == 0)
			return null;
		List target = new ArrayList();
		for (Map o : from) {
			target.add(transfer(o, targetClass));
		}
		return target;

	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List transferList(List from, Class targetClass) {
		if (from == null || from.size() == 0)
			return null;
		List target = new ArrayList();
		for (Object o : from) {
			target.add(transfer(o, targetClass));
		}
		return target;

	}

	public static String getBig(String filedName) {
		return filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
	}

}
