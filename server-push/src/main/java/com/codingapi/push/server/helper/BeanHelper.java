package com.codingapi.push.server.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 54484
 */
public class BeanHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (BeanHelper.applicationContext == null) {
            BeanHelper.applicationContext = applicationContext;
        }
    }


    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name,Class<T> tClass) {
        return applicationContext.getBean(name,tClass);
    }

}
