package com.mrl.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrl.spring.annotation.dao.BookDao;

@Service
public class BookServiceImpl implements BookService
{
    
    @Autowired
    private BookDao bookDao;
    
}
