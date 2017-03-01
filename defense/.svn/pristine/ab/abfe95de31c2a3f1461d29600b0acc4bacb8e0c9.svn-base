package com.yagout.defense.util;




import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class BeansUtil {
	 /** 
     * 根据bean的名称获取相应类型的对象，使用泛型，获得结果后，不需要强制转换为相应的类型 
     * 
     * @param clazz 
     *            bean的类型，使用泛型 
     * @return T类型的对象 
     */ 
    public static <T> T getBean (Class<T> clazz) { 
        WebApplicationContext wac = ContextLoader 
                .getCurrentWebApplicationContext(); 
        T bean = wac.getBean(clazz); 
        return bean; 
    }
    /** 
     * 根据bean的名称获取相应类型的对象 
     * 
     * @param beanName 
     *            bean的名称 
     * @return Object类型的对象 
     */ 
    public static Object getBean (String beanName) { 
        return ContextLoader.getCurrentWebApplicationContext().getBean(beanName); 
    }
}
