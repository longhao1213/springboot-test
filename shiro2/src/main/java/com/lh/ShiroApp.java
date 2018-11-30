package com.lh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright (C), 2006-2010, ChengDu Lovo info. Co., Ltd.
 * FileName: ShiroApp
 *
 * @author 龙浩
 * @version 1.00
 * @Date 2018/7/31 11:13
 */
@SpringBootApplication
@MapperScan("com.lh")
public class ShiroApp {
    public static void main(String[] args){
            SpringApplication.run(ShiroApp.class, args);
        }
}
