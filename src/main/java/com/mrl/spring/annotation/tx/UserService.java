package com.mrl.spring.annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author lwq
 * @Date 2018/11/28 21:50
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TestDao testDao;

    @Transactional
    public void insertDept(){
        userDao.insert();
//        testDao.insertEMp();
        int i = 1/0;
        System.out.println("插入完成");
    }

}
