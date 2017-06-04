package codewar;

import java.util.List;

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
}
