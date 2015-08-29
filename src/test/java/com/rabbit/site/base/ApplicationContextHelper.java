package com.rabbit.site.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author GuoYankui
 * @version Mar 16, 2015 10:47:18 AM
 * Singleton，创建获取springcontext的helper类
 */
public class ApplicationContextHelper {

    private volatile static ApplicationContextHelper instance;
    private volatile static ApplicationContext applicationContext;

    /**
     * 私有化构造方法
     */
    private ApplicationContextHelper(String... configLocations){
        applicationContext = new ClassPathXmlApplicationContext(configLocations);
    }
    
    /**
     * 工厂方法，传入xml文件名，相对路径即可
     * @param configLocations xml配置文件
     * @return helper实例
     */
    public static ApplicationContextHelper getInstance(String... configLocations){
        if(instance == null){
            synchronized (ApplicationContextHelper.class){
                if(instance == null){
                    instance = new ApplicationContextHelper(configLocations);
                }
            }
        }
        return instance;
    }

    public <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}
