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

    /**
     * 使用可变参数列表
     *
     * @param args
     */
    public void varargs(Object... args) {
        for (Object o : args) {
            System.out.println(o.toString());
        }
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

    public void play(PC pc) {
        PC pc1 = pc.getGame();
    }

    class PC {
        public PC getGame() {
            Getter g = new Getter();
            return g.get(this);
        }
    }

    class Getter {
        public PC get(PC pc) {
            return pc;
        }
    }
}

