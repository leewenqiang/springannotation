package com.mrl.spring.annotation.controlor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.mrl.spring.annotation.service.BookService;

@Controller
public class BookControlor
{
    @Autowired
    @Qualifier("bookServiceImpl")
    BookService bookService;
}
