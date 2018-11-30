package com.lh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 龙浩 on 2018/7/9.
 */
@SpringBootApplication
@EnableEurekaServer
public class app {
    public static void main(String[] args){
        SpringApplication.run(app.class,args);
    }
}
