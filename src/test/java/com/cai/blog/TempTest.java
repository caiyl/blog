package com.cai.blog;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by caiyl on 2017/6/25.
 */
public class TempTest extends TestCase {

    @Test
    public void testCollection(){
        System.out.println(Runtime.getRuntime().availableProcessors());
        String s = "a";

        System.out.println(s.hashCode());
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode("b"));
    }

    @Test
    public void testPriorityBlockingQueue(){
        PriorityBlockingQueue q = new PriorityBlockingQueue();
        q.put(1);
        q.put(9);
        q.put(2);
        q.put(8);
        q.put(7);
        q.put(4);
        q.put(3);

        for ( int i = 0;i<7;i++){
            try {
                System.out.println(q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testType(){




    }
}
