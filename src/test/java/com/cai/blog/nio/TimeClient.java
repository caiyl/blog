package com.cai.blog.nio;

/**
 * Created by caiyl on 2017/6/18.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8888;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        new Thread(new TimeClientHandle("127.0.0.1",port), "TimeClient-001").start();
    }
}
