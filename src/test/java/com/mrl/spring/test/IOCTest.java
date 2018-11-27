package com.mrl.spring.test;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrl.spring.annotation.bean.BigApple;
import com.mrl.spring.annotation.bean.Blue;
import com.mrl.spring.annotation.bean.Person;
import com.mrl.spring.annotation.config.MainConfig;

public class IOCTest
{
    
    ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
    
    @Test
    public void test01() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取容器中所有bean的name
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        //打印
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
    
    @Test
    public void test02() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
        ioc.getBean(Person.class);
        ioc.getBean(Person.class);
        ioc.getBean(Person.class);
    }
    
    @Test
    public void test03() {
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        
       System.out.println( ioc.getEnvironment().getProperty("os.name"));
        
        //打印
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        
        Map<String, Person> persons = ioc.getBeansOfType(Person.class);
        System.err.println(persons);
    }
    
   
    public void printBeans() {
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        

        //打印
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        
    }
    
    @Test
    public void testIMport() {
        printBeans();
        //工厂bean获取的是调用getObject返回的对象
//        Object o = ioc.getBean("myFactoryBean");
//        System.out.println("O;"+o);
        
      //工厂bean获取的是调用getObject返回的对象
      Object o = ioc.getBean("&myFactoryBean");
      System.out.println("O;"+o);
    }

}
