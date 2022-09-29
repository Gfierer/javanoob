package com.java.ThreadExer;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元， 每次存1000， 存3次。每次存完打
 * 印账户余额。
 *
 * @author jgzuishuai
 * @create 2022-09-18-8:44
 */
class Account2 {
    double balance2 = 0;

    public Account2(double balance2) {
        this.balance2 = balance2;
    }

    public  void deposit2(double atm) {
        synchronized(this){
        balance2 += atm;
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() +
                "充值成功，账户余额 ：" + balance2);
    }
    }
}

class Customer2 implements Runnable {
    private Account2 acc2;

    public Customer2(Account2 acc2) {
        this.acc2 = acc2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc2.deposit2(1000);
        }
    }
}

public class ThreadExer2 {
    public static void main(String[] args) {
        Account2 acct = new Account2(0);
        Customer2 cust2 = new Customer2(acct);
        Thread t1 = new Thread(cust2);
        Thread t2 = new Thread(cust2);
        t1.setName("用户一");
        t2.setName("用户二");
        t1.start();
        t2.start();
    }

}
