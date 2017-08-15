/*
package codewar;

import java.util.*;

*/
/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/19
 * Time:13:42
 *//*

public class P170619 {
    public static int duplicateCount(String text) {
        int ans = 0;
        //avoid A a
        text = text.toLowerCase();
        while (text.length() > 0) {
            String firstLetter = text.substring(0, 1);
            text = text.substring(1);
            if (text.contains(firstLetter)) ans++;
            text = text.replace(firstLetter, "");
        }
        return ans;
    }

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
        */
/**
         * because when number to a/2 there only have number itself to divide
         *//*

        for (int i = 1; i <= a / 2; i++) {
            if (a % i == 0) {
                count++;
            }
        }
        return count + 1;
    }

    public String encode(String source) {
        String result = "";
        if (source == null) return "";
        else if (source.contains("a") ||
                source.contains("A") ||
                source.contains("e") ||
                source.contains("E") ||
                source.contains("l") ||
                source.contains("L") ||
                source.contains("m") ||
                source.contains("M") ||
                source.contains("o") ||
                source.contains("O") ||
                source.contains("U") ||
                source.contains("u")) {
            result = source.replace('a', '4');
            result = result.replace('A', '4');
            result = result.replace('e', '3');
            result = result.replace('E', '3');
            result = result.replace('l', '1');
            result = result.replace('L', '1');
            result = result.replace('o', '0');
            result = result.replace('O', '0');
            result = result.replace("m", "/^^\\");
            result = result.replace("M", "/^^\\");
            result = result.replace("u", "(_)");
            result = result.replace("U", "(_)");

            return result;
        } else {
            return source;
        }

    }

    public String encode1(String source) {
        if (source == null) {
            return "";
        }
        //using hashmap store the encoder rules
        Map<Character, String> dictionary = new HashMap<>();
        dictionary.put('a', "4");
        dictionary.put('e', "3");
        dictionary.put('l', "1");
        dictionary.put('m', "/^^\\");
        dictionary.put('o', "0");
        dictionary.put('u', "(_)");
        StringBuilder out = new StringBuilder();
        for (char c : source.toCharArray()) {
            //get from dic if have one
            String temp = dictionary.get(Character.toLowerCase(c));
            if (temp == null) {
                temp = Character.toString(c);
            }
            out.append(temp);
        }
        System.out.println(out.toString());
        return out.toString();
    }

}
*/
