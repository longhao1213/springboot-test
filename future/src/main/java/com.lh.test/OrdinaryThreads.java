package com.lh.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: OrdinaryThreads.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/09 17:33
 */
public class OrdinaryThreads {
    public static class eat extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class drink extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();

        eat eat = new eat();
        eat.start();
        eat.join();

        drink drink = new drink();
        drink.start();
        drink.join();

        System.out.println(System.currentTimeMillis() - l);
    }
}