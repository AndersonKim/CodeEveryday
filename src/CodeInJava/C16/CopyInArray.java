package CodeInJava.C16;

import java.util.Arrays;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/17
 * Time:10:56
 */
public class CopyInArray {
    public void _1671() {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i:" + Arrays.toString(i));
        System.out.println("j:" + Arrays.toString(j));
        System.arraycopy(i, 0, j, 1, 1);
        System.out.println("j:" + Arrays.toString(j));
        int[] k = new int[5];
        Arrays.fill(k, 103);
    }
}
