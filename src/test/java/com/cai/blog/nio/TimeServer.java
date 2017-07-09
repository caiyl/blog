package com.cai.blog.nio;

/**
 * Created by caiyl on 2017/6/18.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8888;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();

    }
}
