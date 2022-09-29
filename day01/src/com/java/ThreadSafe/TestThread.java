package com.java.ThreadSafe;

/**
 * 多线程的创建:
 * 方式一：继承于thread类
 * 1.创建一个继承于Thread类的子类。
 * 2.重写Thread类的run（） --> 将此线程执行的操作声明在run（）中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start（）
 *
 * <p>
 * 例子：遍历100以内的所有的偶数
 *
 * @author jgzuishuai
 * @create 2022-09-12-19:21
 */
//    创建一个继承于Thread类的子类。
class MyThread4 extends Thread {
    //    重写Thread类的run（）
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class TestThread {

    public static void main(String[] args) {
//        创建Thread类的子类的对象
        MyThread4 t1 = new MyThread4();
//        4.通过此对象调用start（）  ..启动当前线程 调用当前线程的run（）
//        问题一：不能通过直接调用run（）的方式启动线程。
//        t1.run(); ×
//
//        问题二：再启动一个线程：遍历100以内的偶数  不能让已经start（）的
//        线程去执行
//        t1.start();
//          重新创建一个线程的对象
        MyThread4 t2 = new MyThread4();

        t2.start();
        t1.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                System.out.println(i + "hello");

            }
        }
    }
}
