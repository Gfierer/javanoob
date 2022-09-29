package String;

import org.junit.Test;

/**
 * String： 不可变的字符序列 底层使用char[]存储
 * StringBuffer:可变的字符序列 ，线程安全的、效率低，底层使用char[]存储
 * StringBuilder：可变的字符序列；jdk5.0新增，线程不安全，效率高；底层
 * 使用char[]存储
 *
 * @author jgzuishuai
 * @create 2022-09-21-15:08
 */
public class StringBufferStringBuilder {
    @Test
    public void Test(){
        String s1 = new String();// char[] value = new char[0];

//        初始容量为16的字符串缓冲区
        StringBuffer sb1 = new StringBuffer("abc");//char[] value = new char[16]{'a','b','c'};
        sb1.append('1');
        sb1.append('q');
        System.out.println(sb1);
        System.out.println(sb1.length());
        sb1.trimToSize();
        System.out.println(sb1);
        System.out.println(sb1.length());
        System.out.println(sb1.charAt(1));

        System.out.println(sb1.substring(1, 3));
    }
}

