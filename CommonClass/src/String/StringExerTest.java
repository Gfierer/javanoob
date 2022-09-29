package String;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1. 模拟一个trim方法，去除字符串两端的空格。
 * 2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
 * 转为”abfedcg”
 * 3. 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 *
 * @author jgzuishuai
 * @create 2022-09-22-9:02
 */


public class StringExerTest {

    // *1. 模拟一个trim方法，去除字符串两端的空格。

    public String MyTrim(String str) {
        if (str != null) {
            int start = 0;
            int end = str.length() - 1;
            while (start < end && str.charAt(start) == ' ') {
                start++;
            }
            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }
            return str.substring(start, end + 1);
        }
        return null;
    }


    @Test
    public void Test1(){
        StringExerTest stre = new StringExerTest ();
        String str1 = stre.Mytrim1("  asdadf   asf        ") ;
        System.out.println(str1);
    }







    public String Mytrim1(String str){

        if(str != null) {
            int start = 0;
            int end = str.length() - 1;
            while (start < end && str.charAt(start) == ' ') {
                start++;
            }
            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return " ";
            }
            return str.substring(start,end + 1);
        }
        return null;
    }

    public static void main(String[] args) {
        StringExerTest stringExerTest = new StringExerTest();
        String str1 = stringExerTest.MyTrim("  asdfs   afsd   ");
        System.out.println(str1);
    }

/*2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
    转为”abfedcg”*/

//    方式一，char数组方式
    public String reverse1(String str,int start,int end){
        if(str != null) {
//            1.将String转化为char数组
            char[] char1 = str.toCharArray();
//            2.两两交换位置
            for (int i = start, j = end; i < j; i++, j--) {
                char flag = char1[i];
                char1[i] = char1[j];
                char1[j] = flag;
            }
            String s = new String(char1);
            return s;
        }
        return null;
    }


//    方式二：使用String拼接
    public String reverse2(String str,int start,int end){
//        部分一
        String newStr = str.substring(0, start);
//        部分二
        for (int i = end; i >= start; i--) {
            newStr += str.charAt(i);
        }
//        部分三
        newStr += str.substring(end + 1);


        return newStr;
    }


//    方式三 使用StringBuffer/StringBuiler替换String
    public String reverse3(String str,int startIndex,int endIndex){
        StringBuilder builder = new StringBuilder(str.length());
//        第一部分
        builder.append(str.substring(0,startIndex));
//        第二部分
        for (int i = endIndex; i >= startIndex; i--) {
            builder.append(str.charAt(i));
        }
//        第三部分
        builder.append(str.substring(endIndex + 1));

        return builder.toString();
    }

//3. 获取一个字符串在另一个字符串中出现的次数。
//    比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数

    public int getCount(String mainStr,String subStr) {
        if (mainStr.length() >= subStr.length()) {
            int count = 0;
            int index = 0;
//            while (index = mainStr.indexOf(subStr) != -1) {
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
            while((index = mainStr.indexOf(subStr,index)) != -1){
                index += subStr.length();
                count++;
            }
            return count;
        } else {

            return 0;
        }
    }

//    4.获取两个字符串中最大相同子串。比如：
//    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
//    提示：将短的那个串进行长度依次递减的子串与较长的串比较
    public String getMaxSameString(String str1,String str2){


        return null;
    }

//    5.对字符串中字符进行自然顺序排序。
    @Test
    public void Test5(){
        String str1 = "abcwerthelloyuiodef";
        char[] strArr = str1.toCharArray();
        Arrays.sort(strArr);
        String newStr = new String(strArr);
        System.out.println(newStr);
    }

    @Test
    public void Test3(){
        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        System.out.println(getCount(mainStr, subStr));

    }

    @Test
    public void Test2(){
        String str1 = "abcdefghijklmn";
        System.out.println(str1.substring(4));
        String reverse1 = reverse1(str1, 3, 5);
        System.out.println(reverse1);
        System.out.println(str1.indexOf("jk",3));

        String srt2 = "abcdefghijkl";
        System.out.println(reverse2(srt2, 3, 6));
        System.out.println(reverse3(srt2, 3, 6));

    }










}
