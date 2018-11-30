package com.lh.dao;

import java.io.Serializable;

/**
 * Created by 龙浩 on 2018/7/12.
 */
public class User implements Serializable{
    private String id ;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
