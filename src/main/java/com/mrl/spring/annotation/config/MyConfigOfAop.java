package com.mrl.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mrl.spring.annotation.aop.LogAspects;
import com.mrl.spring.annotation.aop.MathCalculate;

/**
 *  AOP:在程序运行期间，动态的将某段代码切入到指定方法指定位置的运行的编程方式
 *  1.导入AOP模块
 *  2.
 *      前置通知：@Before目标方法执行之前
 *      后置通知：@After目标方法执行之后
 *      返回通知：@AfterReturn目标方法正常返回之后
 *      异常通知：@AfterThrowing目标出现异常后运行
 *      环绕通知：@Around目标动态代理，手动推进方法运行
 *      
 *      3,给切面类标注注解
 *      
 *      4.将切面类和业务逻辑类加到容器中，告诉spring哪个是切面类
 *      5.@EnableAspectJAutoProxy 启用aspectj 自动代理 开启基于注解的aspect
 *      EnableXXX开启某一功能
 */
@Configuration
@EnableAspectJAutoProxy
public class MyConfigOfAop
{
    
    @Bean
    public MathCalculate mathCalculate() {
        return new MathCalculate();
    }

    //切面加到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
