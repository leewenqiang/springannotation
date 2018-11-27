package com.mrl.spring.annotation.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean
{

    @Override
    public void destroy() throws Exception {

        System.out.println("cat 销毁调用");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat 初始化");
    }

    public Cat() {
        System.out.println("Cat构造");
    }
}
