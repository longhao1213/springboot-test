package com.lh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.annotation.PostConstruct;

/**
 * Created by 龙浩 on 2018/7/9.
 */
@SpringBootApplication
@EnableEurekaServer
public class app {
    public static void main(String[] args){
        SpringApplication.run(app.class,args);
    }


    private final static Object block1 = new Object();
    private final static Object block2 = new Object();


    /**
     * 模拟线程死锁
     *
     * 这个注解指先项目启动后,用户进程进来之前执行
     */
    @PostConstruct
    public void test(){
        new Thread(()->{
            synchronized (block1){
                System.out.println(Thread.currentThread().getName()+"拿到block1");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (block2){
                    System.out.println(Thread.currentThread().getName()+"拿到block2");
                }
            }
        },"线程1").start();
        new Thread(()->{
            synchronized (block2){
                System.out.println(Thread.currentThread().getName()+"拿到block2");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (block1){
                    System.out.println(Thread.currentThread().getName()+"拿到block1");
                }
            }
        },"线程2").start();
    }
}
