package com.mrl.spring.test;

import com.mrl.spring.annotation.aop.MathCalculate;
import com.mrl.spring.annotation.config.MyConfigOfAop;
import com.mrl.spring.annotation.config.TxConfig;
import com.mrl.spring.annotation.tx.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx
{

    AnnotationConfigApplicationContext ioc = null;

    @Before
    public void before() {
        ioc = new AnnotationConfigApplicationContext(TxConfig.class);
    }

    @Test
    public void test1() {
        UserService bean = ioc.getBean(UserService.class);
        bean.insertDept();
    }

}
