package com.mrl.spring.annotation.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mrl.spring.annotation.dao.BookDao;

/**
 *  自动装配
 *  
 *  Spring利用依赖注入完成对IOC容器对各个组件的依赖关系赋值
 *  
 *      1.@Autowired,默认按照类型优先，如果有多个相同类型的组件，再去按照属性的名字去找，也可以用 @Qualifier("bookServiceImpl")来指定
 *      2.默认一定要将属性值赋值好，没有就会报错，也可以指定requied=false为不必须
 */
@Configuration
@ComponentScan({"com.mrl.spring.annotation.controlor", "com.mrl.spring.annotation.service",
        "com.mrl.spring.annotation.dao" })
public class MyConfigAutowired
{
    
    @Bean
   public BookDao bookDao() {
       return new BookDao();
   }
}
