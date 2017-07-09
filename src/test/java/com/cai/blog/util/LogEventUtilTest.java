package com.cai.blog.util;

import com.google.common.eventbus.Subscribe;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by caiyl on 2017/5/3.
 */
public class LogEventUtilTest extends TestCase {

    @Test
    public void testSub(){
        //注册日志事件监听器
        LogEventUtil.register(new Object(){
            @Subscribe
            public void log(LogEvent e){
                System.out.println(e.toString());
            }
        });

        LogEventUtil.sendEvent(new LogEvent() {
            @Override
            public String toString() {
                return "aaa";
            }
        });
        LogEventUtil.sendEvent(new LogEvent() {
            @Override
            public String toString() {
                return "bbb";
            }
        });
        LogEventUtil.sendEvent("aaaa");

    }
}
