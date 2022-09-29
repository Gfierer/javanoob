package com.Collection.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author jgzuishuai
 * @create 2022-09-27-21:35
 */
public class TestForeach {
    @Test
    public void TestForeach1(){
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("ali",12));
        coll.add(new String("Tom"));
        coll.add("asdf");

//   集合元素的类型 局部变量 ： 集合对象
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void ForTest() {
            String[] str = new String[5];
            for (String myStr : str) {
                myStr = "atguigu";
                System.out.println(myStr);
            }
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
            }
    }
}
