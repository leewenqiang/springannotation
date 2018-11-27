package com.mrl.spring.test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrl.spring.annotation.bean.Car;
import com.mrl.spring.annotation.bean.Person;
import com.mrl.spring.annotation.config.MyConfigAutowired;
import com.mrl.spring.annotation.config.MyConfigLifeCycle;
import com.mrl.spring.annotation.config.MyConfigOfPropertyValues;
import com.mrl.spring.annotation.service.BookService;

public class IOCTestAutowired
{

    AnnotationConfigApplicationContext ioc = null;

    @Before
    public void before() {
        ioc = new AnnotationConfigApplicationContext(MyConfigAutowired.class);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        //打印
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

    @Test
    public void test1() {
       BookService bean = (BookService) ioc.getBean("bookServiceImpl");
       System.err.println(bean.getClass());
    }

}
