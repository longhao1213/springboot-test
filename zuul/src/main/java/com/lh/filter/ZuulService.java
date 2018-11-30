package com.lh.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: ZuulService.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/15 13:06
 */
@Service
@FeignClient(value = "authority",fallback = ZuulHystrixService.class)
public interface ZuulService {

    @RequestMapping("/haveToken")
    Boolean haveToken(@RequestParam("token") String token,@RequestParam("uri") String uri);
}