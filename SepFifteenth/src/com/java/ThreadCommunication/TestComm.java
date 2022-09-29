package com.java.ThreadCommunication;

/**
 * 线程通信例子：
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 涉及三个方法
 *
 * 前提：
 *      只能出现在同步代码块或同步方法中
 *      三个方法的调用者必须是同步代码块或同步方法的同步监视器
 *      否则会出现IllegalMonitorStateException
 *      三个方法都定义在java.lang.Object当中
 *
 * wait():一旦执行，当前线程就进入阻塞状态，并释放同步监视器
 * notify()：一旦执行，就会唤醒被wait的一个线程。如果有多个线程被wait
 *      就唤醒优先级高的
 * notifyAll()：一旦执行，就会唤醒所有被wait的线程
 * @author jgzuishuai
 * @create 2022-09-18-10:06
 */
class Number implements Runnable{
    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj) {
                obj.notify();
                if(number <= 100){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()
                            + " : " + number);
                    number++;
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    break;
                }
            }
        }
    }
}
public class TestComm {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
