package com.mrl.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.mrl.spring.annotation.bean.Person;

/**
 *  
 *   属性配置类
 *   
 *   
 *  
 */
@Configuration
@PropertySource(value= {"classpath:/person.properties"}) //读取外部配置文件
public class MyConfigOfPropertyValues
{
    @Bean
     public Person person() {
         return new Person();
     }
}
