package com.lh.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright (C), 2006-2010, ChengDu Lovo info. Co., Ltd.
 * FileName: ShiroConfig
 *
 * @author 龙浩
 * @version 1.00
 * @Date 2018/8/2 9:13
 */
@Configuration
public class ShiroConfig {

    final static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    /**
     * 拦截器工厂
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置值,默认会自动寻找web工程下的/login.jsp或者/login的映射
        shiroFilterFactoryBean.setLoginUrl("/notLogin");
        // 设置没有权限时跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        // 设置拦截器 拦截器链
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 游客 开放权限
        // 游客,开放权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        // 用户,需要角色权限 user
        filterChainDefinitionMap.put("/user/**", "roles[user]");
        // 管理员,需要角色权限 admin
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        filterChainDefinitionMap.put("/admin/**", "roles[user]");
        // 开放登录接口
        filterChainDefinitionMap.put("/login", "anon");
        // 其余接口一律拦截
        // 主要这行代码必须方法所有权限设置之后,不然会导致所有的url都被拦截
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        logger.info("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }
    /**
     * 注入 securityManager
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        securityManager.setRealm(shiroRealm());
        logger.info("添加了自定义身份认证");
        return securityManager;
    }

    /**
     *
     */
//    @Bean
//    public DefaultWebSessionManager configWebSessionManager(){
//        DefaultWebSessionManager manager = new DefaultWebSessionManager();
//        manager.setCacheManager(cacheManager);// 加入缓存管理器
//        manager.setSessionDAO(sessionDao);// 设置SessionDao
//        manager.setDeleteInvalidSessions(true);// 删除过期的session
//        manager.setGlobalSessionTimeout(sessionDao.getExpireTime());// 设置全局session超时时间
//        manager.setSessionValidationSchedulerEnabled(true);// 是否定时检查session
//
//        return manager;
//    }
//
//
    /**
     * 自定义身份认证
     */
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }
}
