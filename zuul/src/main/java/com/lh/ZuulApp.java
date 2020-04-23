package com.lh;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by 龙浩 on 2018/7/9.
 */
@SpringBootApplication
@EnableZuulProxy
@MapperScan("com.lh")
@EnableFeignClients
public class ZuulApp {
    public static void main(String[] args){
        SpringApplication.run(ZuulApp.class, args);
    }
}
