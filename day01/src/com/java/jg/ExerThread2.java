package com.java.jg;

/**
 * Runnable 接口的方法创建分线程 并遍历100以内的自然数
 * @author jgzuishuai
 * @create 2022-09-14-17:13
 */
class traverse3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

public class ExerThread2 {
    public static void main(String[] args) {
        traverse3 t3 = new traverse3();
        Thread thread = new Thread(t3);
        thread.setName("线程二");
        thread.start();
    }
}
