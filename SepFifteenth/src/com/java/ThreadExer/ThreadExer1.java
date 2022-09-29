package com.java.ThreadExer;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元， 每次存1000， 存3次。每次存完打
 * 印账户余额。
 * @author jgzuishuai
 * @create 2022-09-17-15:20
 */

class Account{
    private double balance = 0;

    public Account(double balance) {
        this.balance = balance;
    }
    public synchronized void deposit(double amt){

        if(amt > 0){
            balance += amt;
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "充值成功，账户余额： " + balance);
        }
    }
}

class Customer extends Thread{
    private Account acc;

    public Customer(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.deposit(1000);
        }
    }
}
public class ThreadExer1 {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("储户一");
        c2.setName("储户二");

        c1.start();
        c2.start();

    }
}
