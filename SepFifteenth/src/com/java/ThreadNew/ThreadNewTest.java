package com.java.ThreadNew;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口
 *
 *
 *
 *
 * @author jgzuishuai
 * @create 2022-09-18-14:34
 */

class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if(i % 2 ==0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadNewTest {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println("总和" + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
