package CodeInJava.C16;

import java.util.Arrays;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/17
 * Time:11:29
 */
public class ComparingArrays {
    public void _1672() {
        int a[] = new int[10];
        int b[] = new int[10];
        Arrays.fill(a, 10);
        Arrays.fill(b, 10);
        System.out.println(Arrays.equals(a, b));
    }
}
