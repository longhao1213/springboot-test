package com.lh.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: ZuulHystrixService.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/15 13:05
 */
@Component
public class ZuulHystrixService implements ZuulService {
    private final static Logger logger = LoggerFactory.getLogger(ZuulHystrixService.class);

    @Override
    public Boolean haveToken(String token,String uri) {
        return null;
    }
}