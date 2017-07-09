package com.cai.blog.util;

import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executors;

/**
 * Created by tom on 2016/12/15.
 */
public class LogEventUtil {
    static final AsyncEventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool());

    public static void register(Object o){
        eventBus.register(o);
    }

    public static void sendEvent(Object e){
        eventBus.post(e);
    }
}
