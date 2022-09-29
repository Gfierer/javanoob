package com.java.ThreadSafe;

/**
 * @author jgzuishuai
 * @create 2022-09-16-8:54
 */
class Window1 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();

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
                    System.out.println(getName() + "卖票，票号：" +
                            ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }

}

public class ThreadSafety1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}

