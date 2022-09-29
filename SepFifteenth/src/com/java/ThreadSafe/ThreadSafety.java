package com.java.ThreadSafe;

/**
 * 例子 创建三个窗口卖票，总票数未100张
 * 线程安全问题
 * 卖票过程中出现重票、错票 出现线程安全问题
 * 原因：某个线程操作共享数据时，尚未完成时，其他线程参与进来
 * 解决方法，当线程a操作共享数据时，其他线程不能参与，直到a执行完。
 * java当中解决方法：
 * 同步机制
 * 一：同步代码块
 * synchronized（同步监视器）{
 * //需要被同步的代码
 * }
 * 1.操作共享数据的代码，即为需要被同步的代码
 * 2.共享数据：多个线程共同操作的变量。
 * 3.同步监视器，锁
 * 任何一个类的对象都可以充当锁
 * 二、同步方法
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明，
 * 2.非静态的同步方法，同步监视器是 this
 *   静态的同步方法，同步监视器是：当前类本身
 *
 *
 *
 * @author jgzuishuai
 * @create 2022-09-13-17:25
 */

class Window implements Runnable {
    private  int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号：" +
                            ticket);
                    ticket--;
                } else {
                    break;
                }

            }
        }
    }

}

public class ThreadSafety {
    public static void main(String[] args) {
        Window w = new Window();
        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}
