package com.mrl.spring.annotation.config;

import com.mrl.spring.annotation.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ExtendConfig
 * @Description 扩展原理配置类
 * @Author lwq
 * @Date 2018/11/29 9:51
 * @Version 1.0
 *
 *
 *  BeanPostProcessor：bean后置处理器，创建对象初始化前后进行拦截功能
 *  BeanFactoryPostProcessor:beanfactory的后置处理器，
 *      在BeanFacory标准初始化之后；所有的bean定义已经保存加载到beanfactory中，但是bean的实例还未创建
 *
 *  1)ioc容器创建对象
 *  2)执行invokeBeanFactoryPostProcessors(beanFactory);
 *      如何找到BeanFactoryPostProcessors并执行方法呢？
 *          1）直接在BeanFactory中找到所有类型是BeanFactoryPostProcessors并执行方法
 *          2）在初始化创建其他bean之前
 *  2.BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessors
 *      void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
 *     在所有的bean定义信息将要被加载，bean实例还未被创建
 *     优先于BeanFactoryPostProcessor执行，利用BeanDefinitionRegistryPostProcessor给容器额外添加一些组件
 *
 *     原理：
 *     1）ioc创建对象
 *     2）refresh()-》invokeBeanFactoryPostProcessors(beanFactory);
 *     3）从容器中获取所有的BeanDefinitionRegistryPostProcessor组件，依次触发postProcessBeanDefinitionRegistry
 *        再来触发postProcessBeanFactory方法
 *     4）再从容器中找到BeanFactoryPostProcessor,依次触发postProcessBeanFactory
 *
 *  3.ApplicationListener监听容器中发布的事件完成事件驱动模型的开发
 *        监听ApplicationEvent以及下面的字事件
 *
 *    手动开发事件监听：
 *    步骤：
 *    1）写一个监听器来监听某个事件（ApplicationEvent以及子类）
 *       @EventListener注解
 *          原理：使用EventListenerMethodProcessor来解析方法上的EventListener注解
 *              实现了SmartInitializingSingleton->	void afterSingletonsInstantiated();
 *           1)ioc容器
 *           2）	finishBeanFactoryInitialization(beanFactory);
 *           3）smartSingleton.afterSingletonsInstantiated();
 *              1.先创建所有的单实例bean
 *              2.获取所有创建好的单实例bean，判断是否是SmartInitializingSingleton，如果是就调用afterSingletonsInstantiated

 *
 *    2）监听器加入到容器
 *    3）只要容器中事件发布。就能监听到这个事件
 *        ContextRefreshedEvent：容器刷新完成（所有bean都被完全创建），会发布这个事件
 *        ContextClosedEvent：关闭容器发布事件
 *    4）自己发布一个事件：
 *
 *   原理：
 *   1）ContextRefreshedEvent事件：
 *          1）容器创建对象-》refresh()
 *          2）finishRefresh();容器刷新完成
 *          事件发布流程:
 *          3)// Publish the final event.
 *             publishEvent(new ContextRefreshedEvent(this));
 *             发布流程：
 *              1）获取事件的派发器：getApplicationEventMulticaster().multicastEvent(applicationEvent, eventType);事件发送给多个监听器
 *              2）multicastEvent：派发事件
 *              3）获取所有的ApplicationListener,
 *                  1）如果有executor：可以支持使用executor进行异步派发
 *                  2）否则同步执行listener方法 ；invokeListener(listener, event);
 *                      拿到listenr，回调onApplicationEvent方法
 *   2)自己发布事件：同样走事件发布流程
 *      事件派发器：
 *          1）容器创建对象-》refresh-》initApplicationEventMulticaster();
 *            先去容器找applicationEventMulticaster就用，如果没有自己new一个
 *

 *
 *

 */
@Configuration
@ComponentScan("com.mrl.spring.annotation.extend")
public class ExtendConfig {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Blue blue(){
        return new Blue();
    }
}
