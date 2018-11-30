package com.lh.shiro;

import com.lh.dao.AuthorityMapper;
import com.lh.dao.RoleMapper;
import com.lh.dao.UserMapper;
import com.lh.dao.UserRoleMapper;
import com.lh.model.*;
import com.netflix.discovery.converters.Auto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (C), 2006-2010, ChengDu Lovo info. Co., Ltd.
 * FileName: ShiroRealm
 *
 * @author 龙浩
 * @version 1.00
 * @Date 2018/7/31 15:05
 */

public class ShiroRealm extends AuthorizingRealm{
    final static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    private UserMapper userMapper;
    private AuthorityMapper authorityMapper;
    private RoleMapper roleMapper;

    @Autowired
    public void setMapper(UserMapper userMapper, AuthorityMapper authorityMapper, RoleMapper roleMapper) {
        this.authorityMapper = authorityMapper;
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
    }


    /**
     * 获取用户授权的信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("用户权限认证");
        // 获取登录的用户信息
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取用户角色信息
        List<Role> roleList = roleMapper.findAllRoleByUserId(users.get(0).getuId());
        // 添加用户角色信息
        Set<String> roleKeyWord = new HashSet<>();
        for (Role role : roleList) {
            roleKeyWord.add(role.getrKeyword());
        }
        info.setRoles(roleKeyWord);
        // 获取用户权限信息
        List<Authority> authorities = authorityMapper.findAllByUid(users.get(0).getuId());
        for (Authority authority : authorities) {
            info.addStringPermission(authority.getaKeyword());
        }
        return info;
    }

    /**
     * 获取身份验证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("用户身份验证");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        // 从数据库获取对应的用户名密码的用户
        UserExample example = new UserExample();
        example.createCriteria().andUUsernameEqualTo(usernamePasswordToken.getUsername());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() <= 0) {
            logger.error("用户登录用户名或者密码错误");
            throw new AccountException("用户名或者密码错误");
        }
        return new SimpleAuthenticationInfo(usernamePasswordToken.getPrincipal(), users.get(0).getuPassword(), getName());
    }
}
