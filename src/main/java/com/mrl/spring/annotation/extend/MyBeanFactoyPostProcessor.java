package com.mrl.spring.annotation.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName MyBeanFactoyPostProcessor
 * @Description TODO
 * @Author lwq
 * @Date 2018/11/29 10:01
 * @Version 1.0
 */
@Component
public class MyBeanFactoyPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(" MyBeanFactoyPostProcessor ...postProcessBeanFactory");
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("count:"+beanDefinitionCount);
        System.out.println(Arrays.asList(beanDefinitionNames));
    }
}
