package com.mrl.spring.annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author lwq
 * @Date 2018/11/28 21:50
 * @Version 1.0
 */
@Repository
public class TestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertEMp(){
        String sql = "insert into tbl_emp (emp_name) values(?)";
        jdbcTemplate.update(sql, UUID.randomUUID().toString());
    }

}
