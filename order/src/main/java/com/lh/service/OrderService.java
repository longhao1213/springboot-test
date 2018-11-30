package com.lh.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 龙浩 on 2018/7/9.
 */
@FeignClient(value="member",fallback = OrderHystrixService.class)
@Service
public interface OrderService {

    @RequestMapping("/showMember")
    List<String> showMember();

    @RequestMapping(value="/getUser" ,method = RequestMethod.POST)
    User getUser(@RequestBody User user);
}
