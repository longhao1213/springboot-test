package com.lh.service;

import com.lh.config.Redis;
import com.lh.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 龙浩 on 2018/7/12.
 */
@Service
public class RedisService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String,String> valOpsStr;

    @Resource
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOpsObj;

    @Autowired
    private Redis redis;

    /**
     * 根据key获取String
     */
    public String getStr(String key) {
        return valOpsStr.get(key);
    }

    /**
     * 设置Str缓存
     */
    public void setStr(String key, String val) {
        valOpsStr.set(key, val);
    }

    /**
     * 删除指定key
     */
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 获取指定obj缓存
     */
    public Object getObj(Object key) {
        Class<? extends Object> aClass = new User().getClass();
        Object o = redis.get(key, aClass);
        return o;
    }

    /**
     * 设置obj缓存
     * @param o1
     * @param o2
     */
    public void setObj(Object o1, Object o2){
        redis.set(o1, o2);
//        valOpsObj.set(o1, o2);
    }

    /**
     * 删除Obj缓存
     * @param o
     */
    public void delObj(Object o){
        redisTemplate.delete(o);
    }
}
