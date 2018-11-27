package com.mrl.spring.test;

import java.util.Arrays;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrl.spring.annotation.bean.Car;
import com.mrl.spring.annotation.bean.Person;
import com.mrl.spring.annotation.config.MyConfigLifeCycle;
import com.mrl.spring.annotation.config.MyConfigOfProfile;
import com.mrl.spring.annotation.config.MyConfigOfPropertyValues;

public class IOCTest_Profile
{

    AnnotationConfigApplicationContext ioc = null;

    @Before
    public void before() {
        //        ioc = new AnnotationConfigApplicationContext(MyConfigOfProfile.class);
        //        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        //        //打印
        //        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

    @Test
    public void test1() {
        //        String[] beansOfType = ioc.getBeanNamesForType(DataSource.class);
        //        for(String name : beansOfType) {
        //            System.err.println(name);
        //        }

        //1.使用虚拟机命令行参数 -Dspring.profiles.active=环境名
        //2.代码的方式
        ioc = new AnnotationConfigApplicationContext();
        //设置环境
        ioc.getEnvironment().setActiveProfiles("pro");
        //注册主配置类
        ioc.register(MyConfigOfProfile.class);
        //刷新容器
        ioc.refresh();

        //        String[] beansOfType = ioc.getBeanNamesForType(DataSource.class);
        //        for (String name : beansOfType) {
        //            System.err.println(name);
        //        }
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.err.println(name);
        }

    }

}
