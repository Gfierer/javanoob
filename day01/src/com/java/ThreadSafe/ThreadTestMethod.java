package com.java.ThreadSafe;

/**
 * 测试thread中常用方法
 *
 * 1.start()
 * 2.run()
 * 3.currentThread() 静态方法，返回执行当前代码的线程
 * 4.getName()
 * 5.setName()
 * 6.yield() 释放当前cpu的执行权
 * 7.join()  在线程a中调用线程b的 join（） 此时线程a进入阻塞状态 ，直到线程b完全执行完以后
 * 线程a才结束阻塞状态
 * 8.stop() 强制结束当前线程
 * 9.sleep(long millitime) 让当前线程睡眠指定时间，在指定毫秒时间内当前线程是阻塞状态
 * 10.isAlive() 判断当前线程是否存活
 *
 * 线程优先级
 * 1.
 * 2.获取
 * getPriority()
 * setPriority()
 *
 *
 * @author jgzuishuai
 * @create 2022-09-12-21:04
 */

class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2== 0) {
                this.setPriority(6);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+
                        Thread.currentThread().getPriority()+ ":" + i);
            }
            if(i % 20 == 0){
                this.yield();
            }
        }
    }


}
public class ThreadTestMethod {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("thread1 :");
//        m1.setName("线程1");
        m1.start();


//        给主线程命名
        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() +
                        Thread.currentThread().getPriority() + ":" + i);
            }

            if(i == 40){
                try {
                    m1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
}
