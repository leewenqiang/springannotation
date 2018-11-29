package com.mrl.spring.annotation.config;

import com.mrl.spring.annotation.bean.Dog;
import com.mrl.spring.annotation.bean.MyBeanPostProcessor;
import com.mrl.spring.annotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mrl.spring.annotation.bean.Car;
import org.springframework.context.annotation.Import;

/**
 *  bean的声明周期  创建--初始化---销毁，
 *              容器管理
 *      可以自定义bean的初始化和销毁方法
 *      1）指定初始化方法和销毁方法  配置文件可以指定init-method  和 destroy-method
 *   
 *  构造创建对象：
 *      单实例对象：容器创建的时候创建（容器关闭的时候进行销毁）
 *      多实例方法：每次获取的时候创建（容器不会销毁，不会管理，不会调用销毁方法）
 *            1.           通过@Bean的initMethod和destroyMethod指定初始化(容器创建并赋值之后)和销毁方法
 *            
 *            2.InitializingBean的afterPropertiesSet
         *                                 让Bean实现InitializingBean对象定义初始化逻辑 
                           让Bean实现  DisposableBean定义销毁逻辑
                           
             3.
                             使用@PostConstruct标注在方法上，在bean创建完成并且属性赋值完成，执行初始化
                            使用@PreDestroy标注在方法上，在bean销毁之前被调用
        
        
        4.BeanPostProcessor:bean的后置处理器
                            在bean的初始化前后做一些工作:
                                postProcessBeforeInitialization:初始化之前（调用初始化方法之前，在给bean赋值之后(setter方法之后)）
                                postProcessAfterInitialization：初始化之后
 *              遍历所有的BeanPostProcessor执行，一旦返回null，返回，停止执行
 *      
 *  [功能详细描述]
 * @作者 lwq
 * @version [版本号, 2018年9月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本] 
 */
@Configuration
//@ComponentScan("com.mrl")
//@Import({MyBeanPostProcessor.class, Person.class})
@Import({MyBeanPostProcessor.class, Dog.class})
public class MyConfigLifeCycle
{
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
    return new Car("宝马");
}
}
