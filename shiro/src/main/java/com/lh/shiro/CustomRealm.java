package com.lh.shiro;

import com.lh.dao.UserMapper;
import com.lh.model.User;
import com.lh.model.UserExample;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (C), 2006-2010, ChengDu Lovo info. Co., Ltd.
 * FileName: CustomRealm
 *
 * @author 龙浩
 * @version 1.00
 * @Date 2018/7/31 11:35
 */

public class CustomRealm extends AuthorizingRealm {

    private UserMapper userMapper;

    @Autowired
    private void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 获取身份验证信息
     * Shiro中,最终是通过Realm来获取应用程序中的用户,角色及权限信息的
     *
     * @param authenticationToken 用户信息的token
     * @return 返回封装了用户信息的 AuthenticationInfo实例
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("---身份认证方法---");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        // 从数据库获取对应用户名密码的用户
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(token.getUsername());
        List<User> users = userMapper.selectByExample(example);
        String password = users.get(0).getPassword();
        System.out.println("获取用户密码");
        if (null == password) {
            throw new AccountException("用户名不正确");
        } else if (!password.equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
    }

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("---权限认证----");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取该用户角色
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        String role = users.get(0).getRole();
        System.out.println("获取用户角色名称");

        Set<String> set = new HashSet<>();
        // 需要将role封装到Set作为info.setRoles()的参数
        set.add(role);
        // 设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }


}
