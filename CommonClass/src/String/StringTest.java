package String;

/**
 * @author jgzuishuai
 * @create 2022-09-19-9:35
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "efg";
        String s5 = "abcdefg";
        String s3 = "abcd" + s2;

        String s4 = s3.intern();
        System.out.println(s4 == s5);

        System.out.println(s5.length());
    }
}
