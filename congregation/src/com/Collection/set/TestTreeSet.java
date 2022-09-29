package com.Collection.set;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author jgzuishuai
 * @create 2022-09-29-10:53
 */
public class TestTreeSet {
    @Test
    public void testTreeSet(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(123);
        treeSet.add(456);
        treeSet.add(789);
        treeSet.add(435);

        System.out.println(treeSet);
    }
}
