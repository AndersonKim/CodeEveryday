package CodeInJava;

import CodeInJava.C5.MyClass;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/16
 * Time:18:56
 */
public class Test {
    public static void main(String[] args) {
        MyClass a = new MyClass("123");
        a.bark(1);
        a.twen(1, "qwe");
        a.twen("qwe", 1);
    }
}
