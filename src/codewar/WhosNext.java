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

    public String WhoIsNext(String[] names, int n) {
        String result = null;
        ArrayList<String> round = new ArrayList<String>();
        //set init data
        for (String name : names) {
            round.add(name);
        }
        //1.remove first
        //2.add double first to tail
        //3.till tail equals to n
        if (round.size() > n) {
            result = round.get(n - 1);
        } else {

        }

        return result;
    }
}
