package codewar;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/30
 * Time:22:36
 */
public class WhosNext {
    public static void main(String[] args) {
        WhosNext w = new WhosNext();
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        System.out.println(w.WhoIsNext(names, 2));
    }

    public int xn(int counter) {
        int y = 1;
        for (int i = 0; i < counter; ++i) {
            y = y * 2;
        }
        return y;
    }

    public int sum(int counter) {
        int m = 5, ma = 1;
        for (int i = 0; i < counter; i++) {
            ma = ma * 2;
            m = m + 5 * ma;
        }
        return m;
    }

    public int getIndex(int n) {
        int counter;
        int x = 5, y = 1, res = 0;
        if (n < 6) {
            res = n;
        } else {
            counter = 0;
            while (n > sum(counter)) {
                counter++;
            }
            counter = counter - 1;
            n = n - sum(counter);
            res = (n - 1) / xn(counter + 1) + 1;

        }
        if (res == 1) return 1;
        if (res == 2) return 2;
        if (res == 3) return 3;
        if (res == 4) return 4;
        if (res == 5) return 5;
        return 0;
    }

    public String WhoIsNext(String[] names, int n) {
        return names[getIndex(n)];
    }
}
