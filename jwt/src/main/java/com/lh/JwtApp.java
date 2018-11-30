package com.lh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: JwtApp.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/09 17:18
 */
@SpringBootApplication
public class JwtApp {
    private final static Logger logger = LoggerFactory.getLogger(JwtApp.class);
    public static void main(String[] args){
            SpringApplication.run(JwtApp.class, args);
        }
}