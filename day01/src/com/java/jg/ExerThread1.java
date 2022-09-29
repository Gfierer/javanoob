package com.java.jg;

/**
 * 继承Thread的方式创建分线程，并遍历100以内的自然数
 * @author jgzuishuai
 * @create 2022-09-14-16:59
 */
class traverse2 extends Thread{
    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

public class ExerThread1 {
    public static void main(String[] args) {
        traverse2 t1 = new traverse2();
        t1.setName("线程一");
        t1.start();
    }
}
