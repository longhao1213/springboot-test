package com.lh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: MyFilter.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/15 10:54
 */
@Component
public class MyFilter extends ZuulFilter{
    private final static Logger logger = LoggerFactory.getLogger(MyFilter.class);
    @Autowired
    private ZuulService zuulService;


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        HttpServletResponse response = ctx.getResponse();
//        try {
//            request.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        response.setHeader("Content-type","text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        // 获取请求参数中的token
//        String token = request.getParameter("token");
//        // 调动权限验证,如果通过通过校验,就放心,如果没有通过校验,就返回
//        if (token == null) {
//            token = "1";
//        }
//        String uri = request.getRequestURI();
//        Boolean b = zuulService.haveToken(token,uri);
//        if (!b) { // 假判断,到时候调用权限服务
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("你无权访问");
//            return null;
//        }else{
//            ctx.setSendZuulResponse(true);
//            ctx.setResponseStatusCode(200);
//            ctx.set("isSuccess",true);
//            return null;
//        }
        System.out.println("=================");
        return null;
    }
}