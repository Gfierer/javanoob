package com.java.ThreadSafe;

/**
 * @author jgzuishuai
 * @create 2022-09-16-10:57
 */
public class BankTest{

}
class Bank {
    private Bank(){}
    private static Bank instance = null;
    private static  Bank getInstance() { //bank.class

//        方式一，效率较差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }

//        方式二.
        if(instance == null){
            synchronized(Bank.class){
                if (instance == null){
                    instance = new Bank();
                }

            }
        }
        return instance;

    }
}


