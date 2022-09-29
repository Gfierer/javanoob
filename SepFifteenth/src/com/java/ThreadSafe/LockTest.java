package com.java.ThreadSafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 方式三 Lock锁 jdk5.0 新增
 * synchronized or Lock异同
 * 相同：二者都可以解决线程安全问题
 * <p>
 * 不同： synchronized机制在执行完相应的同步代码之后，自动释放同步监视器
 * Lock需要手动的启动同步（Lock()）。同时结束是需要手动停止（ unlock()）
 * 优先使用顺序
 * Lock → 同步代码块（已经进入了方法体，分配相应资源） →同步方法（方法体之外）
 * <p>
 * 面试题
 * 如何解决线程安全问题
 *
 * @author jgzuishuai
 * @create 2022-09-16-11:28
 */
class window5 implements Runnable {
    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();

            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        window5 w = new window5();
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
