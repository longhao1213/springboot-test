package com.gen;

import com.gen.dao.MenuMapper;
import com.gen.dao.UserMapper;
import com.gen.model.*;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 龙浩 on 2018/7/10.
 */
@SpringBootApplication
@MapperScan("com.gen")
@RestController
public class HelperApp {

    public static void main(String[] args) {
        SpringApplication.run(HelperApp.class, args);
    }


    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findByPage")
    public List<User> findByPage(int num, int size) {
        PageHelper.startPage(num, size);
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Autowired
    private MenuMapper menuMapper;


    @RequestMapping("/test")
    public Menu test(){
        return menuMapper.selectByPrimaryKey("1");
    }

    @RequestMapping("/sanji")
    public List<MenuPo> testQueryMenuList() {
        // 原始的数据
        MenuExample example = new MenuExample();
        List<Menu> rootMenu1 = menuMapper.selectByExample(example);
        List<MenuPo> rootMenu = new ArrayList<>();
        for (Menu menu : rootMenu1) {
            MenuPo menuPo = new MenuPo();
            menuPo.setIcon(menu.getIcon());
            menuPo.setId(menu.getId());
            menuPo.setUsername(menu.getUsername());
            menuPo.setParentId(menu.getParentId());
            menuPo.setUrl(menu.getUrl());
            menuPo.setOrdersort(menu.getOrdersort());
            rootMenu.add(menuPo);
        }

        // 查看结果
        for (MenuPo menu : rootMenu) {
            System.out.println(menu);
        }
        // 最后的结果
        List<MenuPo> menuList = new ArrayList<>();
        // 先找到所有的一级菜单
        for (int i = 0; i < rootMenu.size(); i++) {
            // 一级菜单没有parentId
            if (StringUtils.isBlank(rootMenu.get(i).getParentId())) {
                menuList.add(rootMenu.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (MenuPo menu : menuList) {
            menu.setChildMenus(getChild(menu.getId(), rootMenu));
        }
        return menuList;

    }
    /*
     * 递归查找子菜单
     *
     * @param id
     *            当前菜单id
     * @param rootMenu
     *            要查找的列表
     * @return
     */
    private List<MenuPo> getChild(String id, List<MenuPo> rootMenu) {
        // 子菜单
        List<MenuPo> childList = new ArrayList<>();
        for (MenuPo menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(menu.getParentId())) {
                if (menu.getParentId().equals(id)) {
                    childList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (MenuPo menu : childList) {// 没有url子菜单还有子菜单
            if (StringUtils.isBlank(menu.getUrl())) {
                // 递归
                menu.setChildMenus(getChild(menu.getId(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
