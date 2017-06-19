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


        for (int i = 1; i < nMax - diff; i++) {
            if (countDivisors(i) == countDivisors(i + diff))
                count++;
        }

        return count;
    }

    public int countDivisors(int a) {
        int count = 0;
        //using a/2 to decrease the consume of memory
        /**
         * because when number to a/2 there only have number itself to divide
         */
        for (int i = 1; i <= a / 2; i++) {
            if (a % i == 0) {
                count++;
            }
        }
        return count + 1;
    }


}
