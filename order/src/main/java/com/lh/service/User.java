package com.lh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: User.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/16 09:48
 */
public class User implements Serializable{
    private final static Logger logger = LoggerFactory.getLogger(User.class);
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}