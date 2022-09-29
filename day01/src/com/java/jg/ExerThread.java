package com.java.jg;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，
 * 另一个线程遍历100以内的奇数。
 * @author jgzuishuai
 * @create 2022-09-12-20:43
 */

class Traverse extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "偶数： "+ i);
            }
        }
    }
}

class Traverse1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + "奇数： " + i);
            }
        }
    }
}

public class ExerThread {
    public static void main(String[] args) {
//        Traverse t1 = new Traverse();
//        Traverse1 t2 = new Traverse1();
//        t1.start();
//        t2.start();

        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + "偶数： "+ i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 1){
                        System.out.println(Thread.currentThread().getName() + "奇数： " + i);
                    }
                }
            }
        }.start();

    }
}
