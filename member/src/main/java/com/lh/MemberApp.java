package com.lh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 龙浩 on 2018/7/9.
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lh")
public class MemberApp {

    public static void main(String[] args){
        SpringApplication.run(MemberApp.class, args);
    }
}
