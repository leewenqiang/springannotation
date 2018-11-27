package com.mrl.spring.annotation.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class Dog implements ApplicationContextAware
{
    public Dog() {
        System.out.println("Dog....Constcotor...");
    }
    
    private ApplicationContext app;
    
    //对象创建并赋值之后调用
    @PostConstruct
    public void init() {
        System.out.println("Dog....init...");
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Dog....destroy...");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.app = applicationContext;
    }
    
}
