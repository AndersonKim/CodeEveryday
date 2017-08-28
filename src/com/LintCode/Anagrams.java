package LintCode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/*
    Given an array of strings, return all groups of strings that are anagrams.
    Example
    Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
    Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
    Note
    All inputs will be in lower-case
    Tags Expand
    String Hash Table

    note that
    anagrams means different char have same times of appear
*/
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        //encoding each str
        for (int i = 0; i < strs.length; i++) {
            //each have it's own codes
            int[] codes = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                //if have char at this pos add 1 as index
                codes[strs[i].charAt(j) - 'a'] += 1;
            }
            String codestr = Arrays.toString(codes);
            if (!map.containsKey(codestr)) {
                //a new start of codestr
                map.put(codestr, new ArrayList<String>());
            }
            map.get(codestr).add(strs[i]);

        }

        //output
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            //have same codes in the list
            if (entry.getValue().size() >= 2) {
                result.addAll(entry.getValue());
            }
        }


        return result;
    }

    @Test
    public void testAnagrams() {
        String[] testCase1 = {"lint", "intl", "inlt", "code"};

        ArrayList<String> testCase1r = new ArrayList<String>();
        testCase1r.add("lint");
        testCase1r.add("intl");
        testCase1r.add("inlt");


        Anagrams anagrams = new Anagrams();
        ArrayList<String> re = (ArrayList<String>) anagrams.anagrams(testCase1);
        assertThat(re, is(testCase1r));
    }
}
