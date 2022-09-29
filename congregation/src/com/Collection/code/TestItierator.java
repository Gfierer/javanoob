package com.Collection.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * Iterator 迭代器  集合元素的遍历操作
 * hasNext() and next()
 * 内部定义了remove（），可以在遍历的时候，删除集合中的元素通过迭代器对象的remove方
 * 法， 不是集合对象的remove方法
 *
 * @author jgzuishuai
 * @create 2022-09-27-16:54
 */
public class TestItierator {
    @Test
    public void Test2Remove(){
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("ali",12));
        coll.add(new String("Tom"));
        coll.add("asdf");

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            if (next.equals("Tom")){
                iterator.remove();
            }

        }

        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void Test1(){
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("ali",12));
        coll.add(new String("Tom"));
        coll.add("asdf");

        //        方式二
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }


//        System.out.println(iterator.next());

        for (Object o : coll) {
            System.out.println(o);
        }

        System.out.println();

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

//        错误方式，原因集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合
//的第一个元素之前
        /*while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());

        }*/

    }


}
