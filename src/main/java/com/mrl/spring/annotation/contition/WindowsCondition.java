package com.mrl.spring.annotation.contition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

public class WindowsCondition implements Condition
{

    /*  metadata注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        //ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //类加载器
        ClassLoader classLoader = context.getClassLoader();
        //bean的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        
        String osName = environment.getProperty("os.name");
        if(!StringUtils.isEmpty(osName) && osName.toLowerCase().contains("windows")) {
            return true;
        }
        return false;
    }

}
