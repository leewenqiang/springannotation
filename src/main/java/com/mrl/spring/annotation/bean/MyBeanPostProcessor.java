package com.mrl.spring.annotation.bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *  后置处理器：
 *  
 *  [功能详细描述]
 * @作者 lwq
 * @version [版本号, 2018年9月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本] 
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor
{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
           System.out.println("postProcessBeforeInitialization:::"+beanName+":::"+bean);
           if(bean instanceof Car) {
               System.out.println("处理Car对象");
               Car car = (Car) bean;
               car.setName("宝马-》postProcessBeforeInitialization");
               System.out.println("postProcessBeforeInitialization：name:"+car.getName());
               return bean;
           }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:::"+beanName+":::"+bean);
        if(bean instanceof Car) {
            System.out.println("处理Car对象2");
            Car car = (Car) bean;
            car.setName("初始化后做的工作");
            System.out.println("postProcessBeforeInitialization：name:"+car.getName());
            return bean;
        }
        return bean;
    }

}
