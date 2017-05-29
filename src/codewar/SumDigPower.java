package codewar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/23
 * Time:0:05
 */
public class SumDigPower {
    public static List<Long> sumDigPow(long a, long b) {
        List<Long> numberArList = new ArrayList<>();        //returning ArrayList of Long
        while (a <= b) {                                       //inbetween the range
            String stringFromInt = new StringBuilder().append(a).toString();    //converting every number to string
            int[] intArFromString = new int[stringFromInt.length()];
            double sum = 0;
            for (int i = 0; i < stringFromInt.length(); i++) {
                intArFromString[i] = stringFromInt.charAt(i) - '0';     //getting into int array by substracting 0 ASCI code
                sum = sum + Math.pow(intArFromString[i], i + 1);
            }           //math
            int sumInt = (int) sum;     //type casting to make it equal to long
            if (a == sumInt) {
                numberArList.add(a);
            }
            a++;
        }                 //increasing the input number
        return numberArList;
    }
}
