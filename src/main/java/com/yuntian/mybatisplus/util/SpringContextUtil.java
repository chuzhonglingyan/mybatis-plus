package com.yuntian.mybatisplus.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Auther: yuntian
 * @Date: 2019/6/30 0030 21:05
 * @Description:
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(Class T){
        try {
            return applicationContext.getBean(T);
        }catch (BeansException e){
            return null;
        }
    }

    public static Object getBean(String name){
        try {
            return applicationContext.getBean(name);
        }catch (BeansException e){
            return null;
        }
    }


}
