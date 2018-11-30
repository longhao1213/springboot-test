package com.lh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: MongoDbController.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/07 14:32
 */
@RestController
public class MongoDbController {
    private final static Logger logger = LoggerFactory.getLogger(MongoDbController.class);

    @Autowired
    private CustomerRepository repository;

    static long i = 1;

    @RequestMapping("/test")
    public long test(){
        long a = System.currentTimeMillis();
        for (int i1 = 0; i1 < 100000; i1++) {
                        repository.save(new Customer("Alice","Smith","Alice","Smith","Alice","Smith","Alice","Smith","Alice","Smith","Alice","Smith","Alice","Smith","Alice","Smith","Alice","Smith"));
                    }
        long j = System.currentTimeMillis();
        i = j-a;
        System.out.println(i);

        return i;
    }

    @RequestMapping("/test2")
    public void test2(){

    }
}