package com.lh.controller;

import com.lh.service.OrderService;
import com.lh.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 龙浩 on 2018/7/9.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/showMember")
    public List<String> order(){
        return orderService.showMember();
    }

    @RequestMapping("getUser")
    public User getUser(User user) {
        return orderService.getUser(user);
    }
}
