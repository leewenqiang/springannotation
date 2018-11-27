package com.mrl.spring.annotation.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mrl.spring.annotation.bean.Yellow;

/**
 *  
 *  @Profile 指定组件在哪个环境被注册到容器中，不指定都能注册
 *          加了环境标识bean，只有环境被激活的时候，才能注册到容器中.默认是default环境
 *          
 *          写在配置类上，只有是指定环境的时候，整个配置才能生效
 *          没有标注环境的bean，任何环境都会加载
 *  
 */
//@Profile("test")
@Configuration
@PropertySource("classpath:/db.properties")
public class MyConfigOfProfile implements EmbeddedValueResolverAware
{

    @Value("${db.user}")
    private String user;
    
    
    @Profile("test")
    @Bean
    public Yellow yellow() {
        return new  Yellow();
    }

    private StringValueResolver stringValueResolver;

    private String driverClass;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);

        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSouce")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);

        return dataSource;
    }

    @Profile("pro")
    @Bean("proDataSouce")
    public DataSource dataSourcePro(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);

        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
        driverClass = stringValueResolver.resolveStringValue("${db.driverClass}");
    }

}
