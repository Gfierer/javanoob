package com.java.ThreadCommunication;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 *
 * 生产者消费者两个线程
 * @author jgzuishuai
 * @create 2022-09-18-10:57
 */
class Clerk{
    private int stock = 0;

    public synchronized void produceCommodity() {
        if(stock < 20){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stock++;
            System.out.println(Thread.currentThread().getName() +
                    "正在生产第" + stock + "个商品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consumeCommodity() {
        if(stock > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() +
                    "正在消费第" + stock + "个商品");
            stock--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Productor extends Thread{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产");
        while(true) {
            clerk.produceCommodity();
        }
    }
}

class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费");
        while (true) {
            clerk.consumeCommodity();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);
        productor.setName("生产者");
        customer.setName("消费者");
        productor.start();
        customer.start();
    }
}
