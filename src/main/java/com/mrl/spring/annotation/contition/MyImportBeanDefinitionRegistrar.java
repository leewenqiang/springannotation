package com.mrl.spring.annotation.contition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.mrl.spring.annotation.bean.BigApple;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar
{

    /* 
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry: BeanDefinition注册类，可以自定义注册bean（registerBeanDefinition）这个方法
     * 
     *   */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean hasBlue = registry.containsBeanDefinition("com.mrl.spring.annotation.bean.Blue");
        if(hasBlue) {
            BeanDefinition bean = new RootBeanDefinition(BigApple.class);
            registry.registerBeanDefinition("big", bean);
        }
    }

}
