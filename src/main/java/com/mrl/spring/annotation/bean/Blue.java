package com.mrl.spring.annotation.bean;

public class Blue
{
    public Blue() {
        System.out.println("Blue Cons....");
    }

    public void init(){
        System.out.println("blue ... init");
    }

    public void destory(){
        System.out.println("blue ... destory");
    }
}
