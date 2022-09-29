package String;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author jgzuishuai
 * @create 2022-09-21-10:21
 */
public class StringTest1 {
    /**
     * String 与 byte[]的转换
     * 编码 String --> byte[]:调用String 的 getBytes()
     * 解码 byte[] --> String:调用String的构造器
     */
    @Test
    public void Test2() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] b1 = s1.getBytes(); //使用默认的字符集进行转换
        System.out.println(Arrays.toString(b1));


        byte[] gbks = s1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks)); //使用gbk进行编码


        System.out.println("****************");
        String s2 = new String(b1);
        System.out.println(s2);

        String s3 = new String(gbks);
        System.out.println(s3);
    }


    /*
    * String 与 char[]之间的转换
    * String --> char[] :调用Sring的toCharArray()
    * char[] --> String :调用String的构造器。
    */



    @Test
    public void Test1(){
        String s1 = "qwert1234";
        char[] c1 = s1.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            System.out.print(c1[i] + "  ");
        }
        System.out.println();
        char[] c2 = {'h', 'e', 'l', 'l', 'o'};
        String s2 = new String(c2);
        System.out.println(s2);
    }
}
