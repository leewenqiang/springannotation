package com.mrl.spring.annotation;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrl.spring.annotation.bean.Person;
import com.mrl.spring.annotation.config.MainConfig;

public class Main
{
    public static void main(String[] args) throws IOException {
        //        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
        ////        Object bean = app.getBean("person");
        //    
        //        System.in.read();

        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = (Person) ioc.getBean("person");
        System.out.println(bean);
    }
}
