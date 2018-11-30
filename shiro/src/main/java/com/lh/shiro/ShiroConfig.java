package com.lh.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
 * @Date 2018/7/31 11:14
 */
@Configuration
public class ShiroConfig {

    /**
     * 拦截器工厂
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值,默认会自动寻找web工程目录下的/login.jsp或者/login映射
        shiroFilterFactoryBean.setLoginUrl("/notLogin");
        // 设置没有权限时跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

        //设置拦截器  拦截器链
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 游客,开放权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        // 用户,需要角色权限 user
        filterChainDefinitionMap.put("/user/**", "roles[user]");
        // 管理员,需要角色权限 admin
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        // 开放登录接口
        filterChainDefinitionMap.put("/login", "anon");
        // 其余接口一律拦截
        // 主要这行代码必须方法所有权限设置之后,不然会导致所有的url都被拦截
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    /**
     * 注入 securityManager
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        securityManager.setRealm(customRealm());
        System.out.println("添加了自定义身份认证");
        return securityManager;
    }

    /**
     * 自定义身份认证 realm
     * <p>
     *     必须写这个二类,并且加上@Bean注解,目的是注入CustomRealm
     *     否则会影响CustomRealm类中其他类的依赖注入
     * </p>
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

}
