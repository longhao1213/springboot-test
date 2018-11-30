package com.lh.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2006-2010, ChengDu Lovo info. Co., Ltd.
 * FileName: HelloSend
 *
 * @author 龙浩
 * @version 1.00
 * @Date 2018/7/30 10:51
 */
@RestController
public class HelloSend {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/helloSend")
    public void helloSend(String message) {
        amqpTemplate.convertAndSend("hello",message);
    }

    @RequestMapping("/userSend")
    public void userSend(){
        User user = new User();
        user.setPassword("123");
        user.setUsername("name");
        amqpTemplate.convertAndSend("user",user);
    }

    @RequestMapping("/topicSend")
    public void topicSend(){
        amqpTemplate.convertAndSend("exchange","topic.messages","hello topic");
    }

    @RequestMapping("/fanoutSend")
    public void fanoutSend(){
        amqpTemplate.convertAndSend("fanoutExchange","","hello fanout");
    }
}
