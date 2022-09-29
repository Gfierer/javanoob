package String;

/**
 * @author jgzuishuai
 * @create 2022-09-19-9:41
 */
public class ExerTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {
        str = "test ok";  //不可变性
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        ExerTest ex = new ExerTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//
        System.out.println(ex.ch);


    }
}