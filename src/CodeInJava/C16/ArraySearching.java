package CodeInJava.C16;


import java.util.Arrays;
import java.util.Random;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/17
 * Time:15:36
 */
public class ArraySearching {
    public static void main(String[] args) {
        Random r = new Random();
        int[] a = new int[r.nextInt(10)];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
        }
        Arrays.sort(a);

    }
}
