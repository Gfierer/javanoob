package com.java.ThreadSafe;

/**
 * 例子 创建三个窗口卖票，总票数未100张
 *存在线程安全问题，待解决
 * @author jgzuishuai
 * @create 2022-09-14-16:29
 */
class Window1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                ticket--;
            } else {
                return;
            }
        }

    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Thread w1 = new Thread(window1);
        w1.setName("窗口一");
        Thread w2 = new Thread(window1);
        w2.setName("窗口二");
        Thread w3 = new Thread(window1);
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}
