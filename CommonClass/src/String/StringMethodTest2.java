package String;

import org.junit.Test;

/**
 * boolean endsWith(String suffix)： 测试此字符串是否以指定的后缀结束
 *  boolean startsWith(String prefix)： 测试此字符串是否以指定的前缀开始
 *  boolean startsWith(String prefix, int toffset)： 测试此字符串从指定索引开始的
 *  boolean contains(CharSequence s)： 当且仅当此字符串包含指定的 char 值序列
 * 时，返回 true
 *  int indexOf(String str)： 返回指定子字符串在此字符串中第一次出现处的索引
 *  int indexOf(String str, int fromIndex)： 返回指定子字符串在此字符串中第一次出
 * 现处的索引，从指定的索引开始
 *  int lastIndexOf(String str)： 返回指定子字符串在此字符串中最右边出现处的索引
 *  int lastIndexOf(String str, int fromIndex)： 返回指定子字符串在此字符串中最后
 * 一次出现处的索引，从指定的索引开始反向搜索
 * 注： indexOf和lastIndexOf方法如果未找到都是返回-1
 * 子字符串是否以指定前缀开始
 * @author jgzuishuai
 * @create 2022-09-19-16:06
 */



public class StringMethodTest2 {
    @Test
    public void test1(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.endsWith("rld"));
        System.out.println(s2.startsWith("Hell"));
        System.out.println(s1.startsWith("owor", 4));

        System.out.println(s1.contains("Wo"));
        System.out.println(s1.indexOf("ll"));
        System.out.println(s1.indexOf("ld",5));

        System.out.println(s1.lastIndexOf("or"));
        System.out.println(s1.lastIndexOf("or",9));
    }
}
