package String;

import org.junit.Test;

/**
 *  String replace(char oldChar, char newChar)： 返回一个新的字符串， 它是
 * 通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 *  String replace(CharSequence target, CharSequence replacement)： 使
 * 用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 *  String replaceAll(String regex, String replacement) ： 使 用 给 定 的
 * replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
 *  String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
 * replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 * @author jgzuishuai
 * @create 2022-09-21-9:25
 */
public class StringMethodTest3 {
    @Test
    public void Test(){
        String str1 = "河北师范大学";
        System.out.println(str1.replace("河北", "北京"));
        str1.replace("北","东");

        String str2 = "HelloWorld";
        String str3 = str2.replace("H","e");
        System.out.println(str2);
        System.out.println(str3);

        String str4 = "12hello34world5java7891mysql456";
        String str5 = str4.replaceAll("\\d+",",")
                .replaceAll("^,|,$","");
        System.out.println(str5);

        String str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }


    }
}
