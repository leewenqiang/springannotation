package com.mrl.spring.annotation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ClassName TxConfig
 * @Description TODO
 * @Author lwq
 * @Date 2018/11/28 21:44
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.mrl.spring.annotation.tx")
@EnableTransactionManagement  //开启基于注解的事务管理功能
public class TxConfig
{
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ssm_crud");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return  druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    //事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

}
