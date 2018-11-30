package com.lh;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: AuthorityApp.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/15 11:50
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lh")
public class AuthorityApp {
    private final static Logger logger = LoggerFactory.getLogger(AuthorityApp.class);
    public static void main(String[] args){
        SpringApplication.run(AuthorityApp.class, args);
    }
}