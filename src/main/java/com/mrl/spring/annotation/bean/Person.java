package com.mrl.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

public class Person
{
    
    @Value("张三") //赋值,数值，SPEL表达式(#{}), ${},取出配置文件的值（properties)
    private String name;
    
    @Value("${sex}")
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", sex=" + sex + "]";
    }

    public Person(String name, String sex) {
        super();
        this.name = name;
        this.sex = sex;
        System.out.println("有参构造器执行");
    }

    public Person() {
        super();
        System.out.println("无参构造器执行");
    }

}
