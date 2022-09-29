package com.Collection.code;

import org.junit.Test;

import java.util.*;

/**
 * 注：向collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals（）
 *
 *
 * add()添加
 * contains()是否包含某个元素
 * containsAll()
 * remove()删除指定的第一个元素
 * removeAll()取集合差集
 * toArray() 集合-->数组
 * Arrays.asList() 数组-->集合
 * hashcode()获取集合hash值
 *  equals() 比对形参集合和当前集合的元素都相同，顺序也需相同
 * retainAll()取交集
 * @author jgzuishuai
 * @create 2022-09-26-16:22
 */
public class TestCollection {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add(new Person("ali",12));
        boolean b1 = coll.contains(new Person("ali",12));
        System.out.println(b1);

        coll.add(new String("Tom"));
        coll.add("asdf");
        Collection coll1 = Arrays.asList(123,456,"abc");
        System.out.println(coll.containsAll(coll1));

        System.out.println(coll);
        System.out.println(coll.hashCode());
        System.out.println(coll.contains("abc"));
    }


    @Test
    public void Test2(){
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("ali",12));
        coll.add(new String("Tom"));
        coll.add("asdf");

        System.out.println(coll);

        System.out.println(coll.remove("abc"));
        System.out.println(coll.remove("abcds"));
        System.out.println(coll);

        Collection coll1 = Arrays.asList(123,231,"abc");
        coll.removeAll(coll1);
        System.out.println(coll);
    }
    @Test
    public void Test3(){
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("ali",12));
        coll.add(new String("Tom"));
        coll.add("asdf");

        System.out.println(coll);

        Object[] str1 = coll.toArray();
        for (Object o : str1) {
            System.out.println(o);
        }
        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i]);
        }
//        数组 -->集合 调用Arrays静态方法asList（）

        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);

        System.out.println(coll);
        Collection cool1 = Arrays.asList("abc",123,new Person("ali",12));
        Collection cool2 = Arrays.asList("abc",new Person("ali",12),123,"Tom","asdf");
        System.out.println(coll.equals(cool1));
        System.out.println(coll.equals(cool2));
//        System.out.println(coll.retainAll(cool2));
        boolean b = coll.retainAll(cool1);
        System.out.println(b);
        System.out.println(coll);


    }

}
class Person{
    String name;
    int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals()...");
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}



