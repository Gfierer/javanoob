package com.java.ThreadSafe;

/**
 * 同步方法
 *
 * @author jgzuishuai
 * @create 2022-09-16-10:12
 */
class Window2 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();

        }
    }
    private static synchronized void show(){//  锁 this
//        synchronized (obj) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票，票号：" +
                        ticket);
                ticket--;
            }
//        }
    }


}

public class ThreadSafety2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}

