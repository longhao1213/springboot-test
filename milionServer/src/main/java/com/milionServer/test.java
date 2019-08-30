package com.milionServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: test.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/06/14 15:21
 */
public class test {
    public static void main(String[] args){
        String a = "123";
        String b = "123";
        System.out.println(a == b);
        String c = new String("123");
        System.out.println(a == c);
        System.out.println(a == c.intern());
    }
}