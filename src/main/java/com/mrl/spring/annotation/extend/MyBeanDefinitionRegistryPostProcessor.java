package com.mrl.spring.annotation.extend;

import com.mrl.spring.annotation.bean.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyBeanDefinitionRegistryPostProcessor
 * @Description TODO
 * @Author lwq
 * @Date 2018/11/29 10:24
 * @Version 1.0
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    //registry bean定义信息的保存中心  beanFactory就是靠这个registry来创建bean的实例
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry ...bean的数量:"+registry.getBeanDefinitionCount());

        registry.registerBeanDefinition("hello",new RootBeanDefinition(Blue.class));

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory ...bean的数量:"+beanFactory.getBeanDefinitionCount());
    }
}
