package my.enumer.code1;

/**
 * enum关键字
 *
 *      enum主要方法
 *  values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的
 * 枚举值。
 *  valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符
 * 串必须是枚举类对象的“名字”。如不是，会有运行时异常：
 * IllegalArgumentException。
 *  toString()：返回当前枚举类对象常量的名称
 *
 *      使用enum关键字定义的枚举类实现接口的情况
 *          情况一：实现接口，在enum类中实现抽线方法
 *          情况二： 让枚举类的对象分别实现接口中的抽象方法
 *
 * @author jgzuishuai
 * @create 2022-09-26-9:22
 */
interface Info{
    void show();
}

public class TestEnum2  {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        Season1 winter = Season1.WINTER;

        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        System.out.println();
        Thread.State[] thread = Thread.State.values();
        for (Thread.State value : thread){
            System.out.println(value);
        }


        System.out.println(winter);
        System.out.println(summer + " | " + summer.getsName() + " | " + summer.getsDese());
        summer.show();
    }

}


enum Season1 implements Info{
//    1.提供当前枚举类的对象，多个对象间用 " ," 隔开，末尾对象 " ;"结束
     SPRING("春天","春暖花开"){
    @Override
    public void show() {
        System.out.println("春天你好");
    }
},
     SUMMER("夏天","夏日炎炎"){
         @Override
         public void show() {
             System.out.println("宁静的夏天");
         }
     },

     AUTUMN("秋天","硕果累累"){
         @Override
         public void show() {
             System.out.println("秋天不回来");
         }
     },
     WINTER("冬天","冰天雪地"){
         @Override
         public void show() {
             System.out.println("大约在冬季");
         }
     };

//    2.声明Season对象的属性：private final修饰
    private final String sName;
    private final String sDese;
//    3.私有化类的构造器并给对象赋值


    Season1(String sName, String sDese) {
        this.sName = sName;
        this.sDese = sDese;
    }

    public String getsName() {
        return sName;
    }

    public String getsDese() {
        return sDese;
    }

    @Override
    public void show() {
        System.out.println("美好的季节");
    }

   /* @Override
    public String toString() {
        return "Season1{" +
                "sName='" + sName + '\'' +
                ", sDese='" + sDese + '\'' +
                '}';
    }*/
}
