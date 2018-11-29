package com.mrl.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Car
{



    @Autowired
    Person p;

    private String name;
    
    public Car() {
        System.out.println("Car 被创建啦。。。。");
    }
    
    

    public Car(String name) {
        super();
        System.out.println("Car 的有参构造被执行");
        this.name = name;
    }



    public void init() {
        this.name="宝马到玛莎拉蒂";
        System.out.println("Car 被初始化啦。。。。");
    }

    public void destroy() {
        System.out.println("Car 被销毁啦。。。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Car [name=" + name + "]";
    }
    
    
    
    

}
