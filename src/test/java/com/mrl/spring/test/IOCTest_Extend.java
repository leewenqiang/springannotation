package com.mrl.spring.test;

import com.mrl.spring.annotation.config.ExtendConfig;
import com.mrl.spring.annotation.config.TxConfig;
import com.mrl.spring.annotation.tx.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Extend
{

    AnnotationConfigApplicationContext ioc = null;

    @Before
    public void before() {
        ioc = new AnnotationConfigApplicationContext(ExtendConfig.class);
    }

    @Test
    public void test1() {
        ioc.publishEvent(new ApplicationEvent(new String("我发布一个事件")) {
            @Override
            public Object getSource() {
                return super.getSource();
            }

            @Override
            public String toString() {
                return super.toString();
            }
        });
        ioc.close();
    }

}
