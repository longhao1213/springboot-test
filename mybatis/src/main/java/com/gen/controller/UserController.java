package com.gen.controller;

import com.gen.dao.UserMapper;
import com.gen.model.User;
import com.gen.model.UserExample;
import com.gen.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2006-2010, ChengDu Lovo info. Co., Ltd.
 * FileName: ${NAME}
 *
 *
 * @author 龙浩
 * @Date 2018/7/24 17:17
 * @version 1.00
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        UserExample example = new UserExample();
        example.createCriteria();
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    @RequestMapping("/findById")
    public User findById(int id) {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(id);
        List<User> users = userMapper.selectByExample(example);
        return users.get(0);
    }

    @RequestMapping("/findByExample")
    public List<User> findByExample(User user){
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        return userMapper.selectByExample(example);
    }

    @RequestMapping("/mytestfind")
    public List<Users> mytestfind(User user) {
        return userMapper.mytestfind(user);
    }

    @RequestMapping("/test")
    public long test(){
        long a = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setAge(1);
            user.setPassword("1");
            user.setUsername("1");
            user.setSex("1");
            userMapper.insert(user);
        }
        long b= System.currentTimeMillis();
        return  b - a;
    }

    @RequestMapping("/test2")
    public long test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                        User user = new User();
                        user.setAge(1);
                        user.setPassword("1");
                        user.setUsername("1");
                        user.setSex("1");
                        userMapper.insert(user);
                }
            });
        }

        executorService.shutdown();
        long end = 0;
        while (true) {
            if (executorService.isTerminated()) {
                //System.out.println("Finally do something ");
                end = System.currentTimeMillis();
                System.out.println("用时: " + (end - start) + "ms");
                break;
            }

        }
        return end - start;
    }
}
