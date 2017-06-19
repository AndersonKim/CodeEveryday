package codewar;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/19
 * Time:13:42
 */
public class P170619 {
    public int countPairsInt(int diff, long nMax) {
        // your code
        int count = 0;

        int divisorsNum = 0;
        int a = 1;
        while (true) {
            int b = a + diff;
            if (b > nMax) break;
            if (countDivisors(a) == countDivisors(b))
                count++;
            a++;
        }

        return count;
    }

    private int countDivisors(int a) {
        int count = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) count++;
        }
        return count;
    }

    public int countPairsInt1(int diff, long nMax) {
        // your code
        int a = 0;
        return a;
    }
}
