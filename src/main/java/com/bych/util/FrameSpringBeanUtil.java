package com.bych.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description: TODO
 * @Author: lxl
 * @CreateDate: 2019/05/20
 * @Version: V1.0
 */
public class FrameSpringBeanUtil implements ApplicationContextAware {



    private static ApplicationContext applicationContext;



    @Override

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;

    }



    @SuppressWarnings("unchecked")

    public static <T> T getBean(String name){

        return (T) applicationContext.getBean(name);

    }



    public static <T> T getBean(Class<T> cls){

        return applicationContext.getBean(cls);

    }



}