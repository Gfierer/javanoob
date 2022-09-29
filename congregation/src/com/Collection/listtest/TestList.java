package com.Collection.listtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List常用方法
 * 增：add(Object obj)
 * 删:remove(int index) /remove(Object obj)
 * 改:set()
 * 查
 * 插入
 * 长度
 * 遍历
 *
 * @author jgzuishuai
 * @create 2022-09-28-10:32
 */
public class TestList {
    @Test
    public void TestArrayList(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
//        updateList(list);

        list.add(new String("abc"));
        List list1 = Arrays.asList(123, 1231, 345);
        list.addAll(list1);
        System.out.println(list);
    }
    private static void updateList(List list) {
        list.remove(2);
    }


    public static void main(String[] args) {

    }
}
