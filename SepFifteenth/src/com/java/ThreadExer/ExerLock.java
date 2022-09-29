package com.java.ThreadExer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元， 每次存1000， 存3次。每次存完打
 * 印账户余额。
 *
 * @author jgzuishuai
 * @create 2022-09-18-8:44
 */
class Account3 {
    double balance3 = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public Account3(double balance3) {
        this.balance3 = balance3;
    }

    public void deposit3(double atm) {
        lock.lock();
        try {
            balance3 += atm;
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() +
                    "充值成功，账户余额 ：" + balance3);
        }finally{
            lock.unlock();
        }
    }

}

class Customer3 implements Runnable {
    private Account2 acc3;

    public Customer3(Account2 acc3) {
        this.acc3 = acc3;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc3.deposit2(1000);
        }
    }
}

public class ExerLock {
    public static void main(String[] args) {
        Account2 acct = new Account2(0);
        Customer2 cust3 = new Customer2(acct);
        Thread t1 = new Thread(cust3);
        Thread t2 = new Thread(cust3);
        t1.setName("用户一");
        t2.setName("用户二");
        t1.start();
        t2.start();
    }

}

