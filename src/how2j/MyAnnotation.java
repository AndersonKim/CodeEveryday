package how2j;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/30
 * Time:13:03
 */
public class MyAnnotation {
    @Target({METHOD, TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    public @interface TESTString {
        String preStr();

        String postStr();

        String middleStr();
    }

    @TESTString(preStr = "preString",
            postStr = "postString",
            middleStr = "middleString")
    public static class MyAnno {
        public static void main(String[] args) {
            TESTString testString = TESTString.class.getAnnotation(TESTString.class);
            System.out.println(testString.preStr());
            System.out.println(testString.middleStr());
            System.out.println(testString.postStr());
        }
    }
}
