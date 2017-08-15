import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/29
 * Time:10:40
 */
public class EGUtil {
    public static void main(String[] arg) {
        EGUtil egUtil = new EGUtil();
        egUtil.check_enum_type(FileUtil.class);
    }

    public void check_enum_type(Class c) {
        String modifiers = Modifier.toString(c.getModifiers());
        System.out.println("修饰符：\t" + modifiers);
        System.out.println("父类：\t" + c.getSuperclass());
        System.out.println("类名：\t" + c.getName());
        System.out.println("方法：\t");
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("-" + method.getName());
        }
    }

    public enum PLAYER {NORMAL, VIP}
}
