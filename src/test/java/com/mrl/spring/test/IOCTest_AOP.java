package com.mrl.spring.test;

import java.util.Arrays;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrl.spring.annotation.aop.MathCalculate;
import com.mrl.spring.annotation.bean.Car;
import com.mrl.spring.annotation.bean.Person;
import com.mrl.spring.annotation.config.MyConfigLifeCycle;
import com.mrl.spring.annotation.config.MyConfigOfAop;
import com.mrl.spring.annotation.config.MyConfigOfProfile;
import com.mrl.spring.annotation.config.MyConfigOfPropertyValues;

public class IOCTest_AOP
{

    AnnotationConfigApplicationContext ioc = null;

    @Before
    public void before() {
        ioc = new AnnotationConfigApplicationContext(MyConfigOfAop.class);
        //        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        //        //打印
        //        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

    @Test
    public void test1() {
        MathCalculate bean = ioc.getBean(MathCalculate.class);
        int divide = bean.divide(2,0);
        System.out.println("res:"+divide);
    }

}
