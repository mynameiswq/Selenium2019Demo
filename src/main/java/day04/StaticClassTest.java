package day04;

public class StaticClassTest {
    static int a = 2;
    static int b;

    public void test(){
        a = 1;
        b = 2;
    }

    public static void main(String[] args) {
        //main函数被static修饰
        StaticClassTest t = new StaticClassTest();
        t.test();
        main02();
        System.out.println(a);
        System.out.println(b);
    }

    public static void main02(){
        System.out.println(a);
    }


}
