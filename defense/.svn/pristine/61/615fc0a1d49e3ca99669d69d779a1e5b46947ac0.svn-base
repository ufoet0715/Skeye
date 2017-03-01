package com.yagout.defense.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;

public class ObjectUtil {
	private static Logger logger = Logger.getLogger(ObjectUtil.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object transfer(Object from, Class targetClass) {
		if (from == null)
			return null;
		
	
		try {
			Object target = targetClass.newInstance();// 创建实例 类似new出一个目标对象
			Field[] targetFields = targetClass.getDeclaredFields();// 目标对象类型的属性数组
			if(!(targetClass.getSuperclass().isAssignableFrom(Object.class))){
				List<Field> fieldList=Arrays.asList(targetFields);
				List<Field> tmp=new ArrayList<Field>(fieldList);
				tmp.addAll(Arrays.asList(targetClass.getSuperclass().getDeclaredFields()));
				targetFields=tmp.toArray(targetFields) ;
			}
			Method fromMethod = null;
			Method targetMethod = null;
			Object data;// 属性值
			String methodFiled = null;
			for (Field targetField : targetFields) {
			
					fromMethod = null;
					methodFiled = getBig(targetField.getName());
					
					try {
					fromMethod = from.getClass().getDeclaredMethod("get" // 根据
																			// 目标属性获取来源对象get属性的方法
							+ methodFiled);
					} catch (Exception e) {
						
						try {
						fromMethod = from.getClass().getSuperclass().getDeclaredMethod("get" // 根据
								// 目标属性获取来源对象get属性的方法
									+ methodFiled);
						} catch (Exception ex) {
							//logger.info("转换类型获取方法异常" + targetField.getName(),ex);

							Class<?>[] interfaces= from.getClass().getInterfaces();

							for(Class<?> interfaceClass: interfaces){
								try {
								fromMethod =interfaceClass.getDeclaredMethod("get" // 根据
										// 目标属性获取来源对象get属性的方法
										+ methodFiled);
									if(fromMethod!=null) break;
								} catch (Exception em) {

								}
							}

						}
					}
			
				if (fromMethod == null)
					continue;
				data = fromMethod.invoke(from);// 调用来源对象的get方法获取值
				try {
					targetMethod = null;
					targetMethod = targetClass.getDeclaredMethod("set" + methodFiled, data.getClass());

				} catch (Exception e) {
					try {
						targetMethod = null;
						targetMethod = targetClass.getSuperclass().getDeclaredMethod("set" + methodFiled, data.getClass());

					} catch (Exception exc) {
						//logger.info("转换类型存放方法异常" + targetField.getName(), exc);
					}				}
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
					if(entry.getValue() instanceof Timestamp){
						targetMethod = targetClass.getDeclaredMethod("set" + getBig(entry.getKey()),
								Date.class);
					}else {
						targetMethod = targetClass.getDeclaredMethod("set" + getBig(entry.getKey()),
								entry.getValue().getClass());
					}

				} catch (Exception e) {
					//logger.info("转换类型存放方法异常" + entry.getKey(), e);
				}
				if (targetMethod != null){
					if(entry.getValue() instanceof Timestamp){
						targetMethod.invoke(target, new Date(((Timestamp) entry.getValue()).getTime()));
					}else {
						targetMethod.invoke(target, entry.getValue());
					}

				}

			}
			return target;
		} catch (Exception e) {
			logger.error("转换类型异常", e);
			return null;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List transferListMap(List<Map<String,Object>> from, Class targetClass) {
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
		if(filedName.indexOf("_")>0){
			String[] spiltNames=filedName.trim().split("_");
			StringBuffer modefyName=new StringBuffer();
			for(int i=0;i<spiltNames.length;i++){
				modefyName.append(spiltNames[i].substring(0, 1).toUpperCase()+spiltNames[i].substring(1));
			}
			return modefyName.toString();
		}else{
			return filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
		}
	}
	
	public static List<Integer> StringArrayToIntegerList(List<String> elements)
	{
		List<Integer> resultList=new ArrayList<Integer>();
		for (String element:elements) {
			if(StringUtils.isEmpty(element)){
				continue;
			}
			resultList.add(Integer.valueOf(element));
		}
		return resultList;
	}
	
	/**
	 * 将对象转化为map
	 * @param model 对象
	 * @return 返回map
	 */
	public static Map<String, Object> ObjectToMap(Object model){
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Field[] field = model.getClass().getDeclaredFields();
		for (Field f : field) {
			try {
				String name = f.getName();//获取属性的名字
				//将属性名首字母大写，用于获取get/set方法
				String getName = name.substring(0,1).toUpperCase()+name.substring(1);
				Method m = model.getClass().getMethod("get"+getName);//获取get方法的名字
				Object value = m.invoke(model);//利用get方法获取属性值
				map.put(name, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	/**
	 * 将对象转化为map
	 * @param model 对象
	 * @return 返回map
	 */
	public static Map<String, Object> FormatMap(Object model,Map<String, Object> data){
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Field[] field = model.getClass().getDeclaredFields();
		for (Field f : field) {
			try {
				String name = f.getName();//获取属性的名字
				Object value = data.get(name);
				if(value != null && !"".equals(value)){
					map.put(name, value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	/**
	 * 将对象中的有值的属性名替换为数据库中的字段名
	 * @param model 对象
	 * @return 返回数据库字段名集合
	 */
	public static List<String> ObjectToSql(Object model,Map<String, Object> data){
		Field[] field = model.getClass().getDeclaredFields();
		List<String> list = new ArrayList<String>();
		for (Field f : field) {
			String name = f.getName();//获取属性的名字
			try {
				if(data.get(name) != null){
					char[] arraryName = name.toCharArray();//转成char数组
					String sqlName = "";
					for (char c : arraryName) {
						String str = null;
						if((c >='A')&&(c <= 'Z')){
							c = String.valueOf(c).toLowerCase().charAt(0);
							str = "_"+String.valueOf(c);
						}
						if(str != null){
							sqlName = sqlName + str;
						}else{
							sqlName = sqlName + c;
						}
					}
					list.add(sqlName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
