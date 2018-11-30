package com.gen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 龙浩 on 2018/7/24.
 */
@SpringBootApplication
//@EnableEurekaClient
@MapperScan("com.gen")
public class MybatisApp {
    public static void main(String[] args){
        SpringApplication.run(MybatisApp.class, args);
    }
}
