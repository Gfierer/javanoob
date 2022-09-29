package String;

/**
 *
 * int length()： 返回字符串的长度： return value.length
 *  char charAt(int index)： 返回某索引处的字符return value[index]
 *  boolean isEmpty()： 判断是否是空字符串： return value.length == 0
 *  String toLowerCase()： 使用默认语言环境， 将 String 中的所有字符转换为小写
 *  String toUpperCase()： 使用默认语言环境， 将 String 中的所有字符转换为大写
 *  String trim()： 返回字符串的副本， 忽略前导空白和尾部空白
 *  boolean equals(Object obj)： 比较字符串的内容是否相同
 *  boolean equalsIgnoreCase(String anotherString)： 与equals方法类似， 忽略大
 * 小写
 *  String concat(String str)： 将指定字符串连接到此字符串的结尾。 等价于用“+”
 *  int compareTo(String anotherString)： 比较两个字符串的大小
 *  String substring(int beginIndex)： 返回一个新的字符串， 它是此字符串的从
 * beginIndex开始截取到最后的一个子字符串。
 *  String substring(int beginIndex, int endIndex) ： 返回一个新字符串， 它是此字
 * 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
 * @author jgzuishuai
 * @create 2022-09-19-10:07
 */



public class StringMethodTest {
    public static void main(String[] args) {
        String s1 = "JAVAEE";
        String s6 = "JAVAEG";
        System.out.println(s1 + "WWW");
        System.out.println(s1.substring(2));
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(4));
//        System.out.println(s1.charAt(7));
        System.out.println(s1.isBlank());
        System.out.println(s1.isEmpty());
        System.out.println(s1);
        String s2 = s1.toLowerCase();
        System.out.println(s1);
        System.out.println(s2);

        String s3 = "    he  llo   world     ";
        String s4 = s3.trim();
        System.out.println(s3);
        System.out.println(s4);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        String s5 = s3.concat("qwer");
        System.out.println(s5);

        System.out.println(s1.compareTo(s6));


        String t1 = "河北师范大学";
        System.out.println(t1.substring(2));
        System.out.println(t1.substring(1,4));
    }
}


