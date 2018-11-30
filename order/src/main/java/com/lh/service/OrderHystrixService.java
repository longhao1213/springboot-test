package com.lh.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 龙浩 on 2018/7/9.
 */
@Component
public class OrderHystrixService implements OrderService {
    @Override
    public List<String> showMember() {
        List result = new ArrayList();
        result.add("哈哈,断路器启动");
        return result;
    }

    @Override
    public User getUser(User user) {
        return null;
    }
}
