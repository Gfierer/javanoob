package com.Collection.set;

import org.junit.Test;

import java.util.*;

/**
 * @author jgzuishuai
 * @create 2022-09-29-9:11
 */
public class TestSet {
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(789);
        set.add("abc");
        set.add(new Person("Jem",10));
        set.add(new Person("Jem",10));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public  void Test1(){
        HashSet sh1 = new HashSet();
        sh1.add(123);
        sh1.add(1253);
        sh1.add("abc");
        sh1.add("bfg");
        sh1.add(1235);
        sh1.add(new Person("Tom",34));
        sh1.add(new Person("Tom",34));

        Iterator iterator = sh1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

//        System.out.println(sh1);


    }


    class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            System.out.println("equals set ...");
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return name + "\t" +age;
        }
    }
}
