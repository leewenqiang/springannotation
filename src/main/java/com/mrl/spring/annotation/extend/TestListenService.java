package com.mrl.spring.annotation.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestListenService
 * @Description TODO
 * @Author lwq
 * @Date 2018/11/29 11:15
 * @Version 1.0
 */
@Component
public class TestListenService {

    @EventListener(classes = ApplicationEvent.class)
    public void listen(ApplicationEvent event){
        System.out.println("TestListenService ..收到事件");
    }

}
