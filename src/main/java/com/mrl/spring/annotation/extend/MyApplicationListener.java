package com.mrl.spring.annotation.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyApplicationListener
 * @Description TODO
 * @Author lwq
 * @Date 2018/11/29 10:40
 * @Version 1.0
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    //容器中发布此事件，方法触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件:"+event);
    }
}
