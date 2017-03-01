package com.skeye.water_fountain.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ObjectUtil {
	public static String getBig(String filedName) {
		return filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object transfer(Object object, Class targetClass) {
		if (object == null)
			return null;

		try {
			Object target = targetClass.newInstance();
			Field[] targetFields = targetClass.getDeclaredFields();
			Method fromMethod = null;
			Method targetMethod = null;
			String methodField = null;
			Object data = null;
			for (Field targetField : targetFields) {
				methodField = getBig(targetField.getName());
				fromMethod = object.getClass().getDeclaredMethod("get" + methodField);
				if (fromMethod == null)
					continue;
				data = fromMethod.invoke(object);
				targetMethod = targetClass.getDeclaredMethod("set" + methodField, data.getClass());
				if (targetMethod != null) {
					targetMethod.invoke(target, data);
				}
			}
			return targetClass;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object transfer(Map<String, Object> map, Class targetClass) {
		if (map == null || map.size() == 0)
			return null;
		try {
			Object target = targetClass.newInstance();
			Method targetMethod = null;
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				targetMethod = targetClass.getDeclaredMethod("set" + getBig(entry.getKey()),
						entry.getValue().getClass());
				if(targetMethod!=null)
				{
				  targetMethod.invoke(target, entry.getValue());
				}   
			}
			return target;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List transferListFromMap(List<Map> mapList, Class targetClass)
	{
		if (mapList == null || mapList.size() == 0)
			return null;
		List target=new ArrayList();
		for (Map map : mapList) {
			target.add(transfer(map, targetClass));
		}
		return target;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List transferList(List list, Class targetClass)
	{
		if (list == null || list.size() == 0)
			return null;
		List target=new ArrayList();
		for (Object object : target) {
			target.add(transfer(object, targetClass));
		}
		return target;
	}
}
