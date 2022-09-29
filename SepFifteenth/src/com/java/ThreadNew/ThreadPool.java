package com.java.ThreadNew;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *
 *
 * @author jgzuishuai
 * @create 2022-09-18-15:11
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()
                        + " : " + i);
            }
        }
    }
}

class NumberThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()
                        + " : " + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
//        提供指定线程数的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new NumberThread());
        service.execute(new NumberThread2());
        service.shutdown();
    }
}
