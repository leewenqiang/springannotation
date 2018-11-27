package com.mrl.spring.annotation.aop;

public class MathCalculate
{
    public int divide(int i,int j) {
        System.out.println("divide方法被调用...参数是："+i+","+j);
        return i/j;
    }
}
