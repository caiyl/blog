package com.cai.blog.deadlock;

public class DeadLock implements Runnable{
    private int flag;
    static Persion o1 = new Persion("zhangsan"), o2 = new Persion("lisi");      //静态的对象，被DeadLockTest的所有实例对象所公用

    public void run(){

        System.out.println(flag);
        if(flag == 0){
            synchronized(o1){
                try{
                    Thread.sleep(500);
                } catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(o2){
                }
            }
        }
        if(flag == 1){
            synchronized(o2){
                try{
                    Thread.sleep(500);
                } catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(o1){
                }
            }
        }
    }

    public static void main(String[] args){
        DeadLock test1 = new DeadLock();
        DeadLock test2 = new DeadLock();
        test1.flag = 1;
        test2.flag = 0;
        Thread thread1 = new Thread(test1);
        thread1.setName("thread1");
        Thread thread2 = new Thread(test2);
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }
}  