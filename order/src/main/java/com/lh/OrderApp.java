package com.lh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by 龙浩 on 2018/7/9.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderApp {
    public static void main(String[] args){
        SpringApplication.run(OrderApp.class, args);
    }
}
