package com.cai.blog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author renrun.wu
 */
public class MultiThread implements Runnable {
    private int count;
    private int amount = 1;

    public MultiThread() {
        count = 100;
    }

    public MultiThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            amount++;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        MultiThread multiThread =new MultiThread();
        for (int i = 0; i < 100; i++) {
            executorService.execute(multiThread);
        }
        executorService.shutdown();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(multiThread.amount);
    }
}