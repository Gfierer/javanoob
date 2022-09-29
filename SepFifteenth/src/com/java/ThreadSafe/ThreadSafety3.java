package com.java.ThreadSafe;

/**
 * @author jgzuishuai
 * @create 2022-09-16-10:26
 */
class Window3 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
           show();
        }

    }
    private synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
        }
    }
}

public class ThreadSafety3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();
        Thread w1 = new Thread(window3);
        w1.setName("窗口一");
        Thread w2 = new Thread(window3);
        w2.setName("窗口二");
        Thread w3 = new Thread(window3);
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}
