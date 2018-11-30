package com.lh.controller;

import com.lh.dao.AuthorityMapper;
import com.lh.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * Created by 龙浩 on 2018/7/9.
 */
@RestController
//@RequestMapping("/member")
public class MemberController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/showMember")
    public List<String> showMember() {
        List<String> result = new ArrayList<>();
        result.add("zhangsan");
        result.add("lisi");
        result.add(port);
        return result;
    }

    @RequestMapping("/getUser")
    public User getUser(@RequestBody User user) {
        System.out.println(user.getId()+user.getName());
        return user;
    }

    @RequestMapping("/login")
    public Map<String,Object> login(String username,String password) throws NoSuchAlgorithmException {
        Map<String,Object> result = new HashMap();
        if ("longhao".equals(username) && "123456".equals(password)) {
            // 生成token,存入redis
            String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            token =  encoder.encode(md5);
            redisUtils.setStr(token,username); // 这里存储username 实际存储用户id
            List<Authority> authorityByUsername = authorityMapper.findAuthorityByUsername(username);
            result.put("resouce", authorityByUsername);
            result.put("token", token);
            return result;
        }else{
            result.put("message", "密码错误");
            return result;
        }
    }


}
