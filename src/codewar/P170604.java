package codewar;

import java.util.*;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/4
 * Time:13:40
 */
public class P170604 {
    public static Boolean containAllRots(String strng, List<String> arr) {
        // your code
        int flag = 0;
        for (int i = 0; i < strng.length(); i++) {
            StringBuffer s = new StringBuffer();
            s.append(strng.substring(i, strng.length()));
            s.append(strng.substring(0, i));


            if (arr.contains(s.toString())) {
                flag++;
            }
        }
        if (flag == strng.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean containAllRots1(String strng, List<String> arr) {
        // your code
        return true;
    }

    public static String[] lineupStudents(String students) {
        String[] res = students.split(" ");
        Arrays.sort(
                res,
                (a, b) -> (a.length() != b.length()) ?
                        Integer.compare(b.length(), a.length()) :
                        b.compareTo(a)
        );
        return res;
    }

    public static String[] lineupStudents1(String students) {
        String[] res = students.split(" ");
        Arrays.sort(res, new Comp());
        return res;
    }

    static class Comp implements Comparator<String> {
        public int compare(String c1, String c2) {
            int n;
            n = c2.length() - c1.length();
            if (n == 0)
                n = c2.compareTo(c1);
            return n;
        }
    }
}
