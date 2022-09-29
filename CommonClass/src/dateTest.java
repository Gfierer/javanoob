import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jgzuishuai
 * @create 2022-09-24-8:11
 */

public class dateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(System.currentTimeMillis());
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);
        String s = date.toString();
        System.out.println(date.toString());
    }


    @Test
    public void Test1() throws ParseException {
//        实例化
        SimpleDateFormat sdf = new SimpleDateFormat();

//        格式化
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        String str = "2022/9/24 上午8:29";
        Date parse = sdf.parse(str);
        System.out.println(parse);
    }
}
