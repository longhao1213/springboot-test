package com.lh.controller;

import com.lh.dao.User;
import com.lh.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 龙浩 on 2018/7/12.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisService redisService;

    /**
     * 设置Str缓存
     * @param key
     * @param val
     * @return
     */
    @RequestMapping(value = "setStr")
    public String setStr(String key, String val){
        try {
            redisService.setStr(key, val);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 根据key查询Str缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "getStr")
    public String getStr(String key){
        return redisService.getStr(key);
    }


    /**
     * 根据key产出Str缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "delStr")
    public String delStr(String key){
        try {
            redisService.del(key);
            return "success";
        } catch (Exception e){
            return "error";
        }
    }


    /**
     * 设置obj缓存
     * @param key
     * @param user
     * @return
     */
    @RequestMapping(value = "setObj")
    public String setObj(){
        String key = "123";
        User user = new User();
        user.setId("1");
//        user.setName("龙浩");
        try {
            redisService.setObj(key, user);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 获取obj缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "getObj")
    public Object getObj(String key){
        key = "123";
        User user = (User)redisService.getObj(key);
        System.out.println(user);
        return user;
    }


    /**
     * 删除obj缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "delObj")
    public Object delObj(String key){
        try {
            redisService.delObj(key);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
