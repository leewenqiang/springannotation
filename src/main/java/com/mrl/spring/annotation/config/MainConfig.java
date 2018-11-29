package com.mrl.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.mrl.spring.annotation.bean.Color;
import com.mrl.spring.annotation.bean.MyFactoryBean;
import com.mrl.spring.annotation.bean.Person;
import com.mrl.spring.annotation.contition.LinuxCondition;
import com.mrl.spring.annotation.contition.MyImportBeanDefinitionRegistrar;
import com.mrl.spring.annotation.contition.MyImportSelector;
import com.mrl.spring.annotation.contition.WindowsCondition;

//配置类=配置文件
/**
 *  [一句话功能简述]
 *  [功能详细描述]
 * @author lwq
 * @version [版本号, 2018年9月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本] 
 */
@Configuration
//@ComponentScan(value="com.mrl.spring",excludeFilters= {
//        @Filter(type=FilterType.ANNOTATION,classes=Repository.class)
//})
@ComponentScan(value = "com.mrl.spring")
@Import({ Color.class,MyImportSelector.class, MyImportBeanDefinitionRegistrar.class }) //快速导入组件  组件名为全类名//MyImportSelector自定义扫描
public class MainConfig
{

    /**                 1、作用域 @Scope
     *                  2.懒加载，针对单实例bean，在容器启动的时候会初始化bean，配置了懒加载会在使用的时候才去创建 @Lazy
     *                  
     *                  
     *  [功能详细描述]
     *  @return    
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    @Lazy
    @Bean(value = "person") //@Bean注册一个bean到容器中，类型就是返回值的类型，id默认是方法名字 //value指定id
    public Person person() {
        return new Person("测试", "男");
    }

    /**
     *  @Contition 条件
     *  [功能详细描述]
     *  @return    
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    @Bean("bill")
    @Conditional(value = {WindowsCondition.class })
    public Person person01() {
        return new Person("Bill Gates", "男");
    }

    /**
     *  @Contition 条件
     *  [功能详细描述]
     *  @return    
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    @Bean("linux")
    @Conditional(value = {LinuxCondition.class })
    public Person person02() {
        return new Person("linux", "男");
    }

    /**
     *              导入第三方组件
     *      @bean
     *      @Import[快速的容器中导入一个组件] //@Import(Color.class)  快速导入组件  组件名为全类名
     *              ImportSelector:返回需要导入需要导入的全类名
     *              ImportBeanDefinitionRegistrar 手动注册bean到容器中
     *     
     *              
     *                  使用Spring提供的FactoryBean：容器调用getObject返回对象给容器
     *                      
     *              
     * */
    @Bean
    public MyFactoryBean myFactoryBean() {
        return new MyFactoryBean();
    }

}
