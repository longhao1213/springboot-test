package com.lh.test;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2006-2010, ChengDu Lovo info. Co., Ltd.
 * FileName: HelloReceive
 *
 * @author 龙浩
 * @version 1.00
 * @Date 2018/7/30 10:54
 */
@Component
public class HelloReceive {

    @RabbitListener(queues = "hello")
    public void HelloReceive(String message) {
        System.out.println("HelloEec"+message);
    }

    @RabbitListener(queues = "user")
    public void UserReceive(User user) {
        System.out.println("userRec"+user);
    }

    // ===================

    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }

    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }

    // ================
    @RabbitListener(queues="fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:"+str1);
    }
    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }
    @RabbitListener(queues="fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:"+str);
    }
}
