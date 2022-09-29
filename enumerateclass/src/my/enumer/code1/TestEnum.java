package my.enumer.code1;

/**
 *
 * 枚举类
 * 类的对象只有有限个，确定的
 *
 * 1.jdk5.0之前 自定义枚举类
 * 2.jdk5.0之后 enum关键字
 * @author jgzuishuai
 * @create 2022-09-26-8:57
 */
public class TestEnum {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}

class Season{
    /**
     * 自定义枚举类
     *
     * 1.声明Season对象都属性： private final修饰
     *
     * 2.私有化类的构造器，并给对象属性赋值
     */

    private final String sName;
    private final String sDesc;
    private Season(String sName, String sDesc) {
        this.sName = sName;
        this.sDesc = sDesc;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","硕果累累");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    public String getsName() {
        return sName;
    }

    public String getsDesc() {
        return sDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "sName='" + sName + '\'' +
                ", sDesc='" + sDesc + '\'' +
                '}';
    }
}