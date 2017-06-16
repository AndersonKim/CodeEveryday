package CodeInJava.C5;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/16
 * Time:18:57
 */
/*
class MyClass {
    public String str;
    public boolean isNull(){
        return str.equals(null)?true:false;
    }
}
*/
public class MyClass {
    public String str;

    public MyClass() {
        str = "";
        System.out.println("创建了一个对象");
    }

    public MyClass(String arg) {
        System.out.println("使用了 " + arg + " 构造了对象");
    }

    public void bark(int i) {
        System.out.println("int");
    }

    public void bark(char i) {
        System.out.println("char");
    }

    public void bark(String i) {
        System.out.println("String");
    }

    public void bark(float i) {
        System.out.println("float");
    }

    public void twen(int i, String a) {
        System.out.println("1");
    }

    public void twen(String a, int i) {
        System.out.println("2");
    }

    public boolean isNull() {
        return str == null ? true : false;
    }
}

