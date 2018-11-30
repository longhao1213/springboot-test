package com.lh.controller;

import com.lh.dao.AuthorityMapper;
import com.lh.model.Authority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: AuthorityController.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/15 11:52
 */
@RestController
public class AuthorityController {
    private final static Logger logger = LoggerFactory.getLogger(AuthorityController.class);

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Value("${noFilterUrl}")
    private String noFilterUrl;

    @RequestMapping("/haveToken")
    public Boolean haveToken(String token,String uri){
        // 过滤部分不需要权限校验的请求
        Boolean aBoolean = noFilterUrl(uri);
        if (aBoolean == true) {
            return true;
        }
        // 查询该用户是否有请求该页面的权限
        Boolean authority = findAuthority(token, uri);
        if (authority == true) {
            return true;
        }
        String str = redisUtils.getStr(token);
        if (str == null || str == "") {
            return false;
        }else{
            return true;
        }
    }

    /**
     * 过滤不需要权限校验的请求
     */
    public Boolean noFilterUrl(String uri){
        // 读取配置的不需要校验的链接
        String[] split = noFilterUrl.split(",");
        for (String s : split) {
            if (uri.indexOf(s) >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断该用户是否有权限访问该链接
     */
    public Boolean findAuthority(String token,String uri) {
        String username = redisUtils.getStr(token);
        List<Authority> authorityAll = authorityMapper.findAuthorityByUsername(username);
        for (Authority authority : authorityAll) {
            String keyword = authority.getaKeyword();
            if (uri.indexOf(keyword)>=0) {
                return true;
            }
        }
        return false;
    }
}