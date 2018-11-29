package com.mrl.spring.test;

import java.util.Arrays;

import com.mrl.spring.annotation.bean.Car;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrl.spring.annotation.bean.Dog;
import com.mrl.spring.annotation.config.MyConfigLifeCycle;

public class IOCTestLifeCycle
{

    AnnotationConfigApplicationContext ioc = null;

    @Before
    public void before() {
        ioc = new AnnotationConfigApplicationContext(MyConfigLifeCycle.class);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        //打印
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

    @Test
    public void test1() {
        Car bean = ioc.getBean(Car.class);
        System.out.println(bean);
        //容器关闭的时候销毁bean
        ioc.close();
    }

}
