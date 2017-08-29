package com.CodeWar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
* Everyone knows passphrases.
* One can choose passphrases from poems, songs, movies names and so on
 * but frequently they can be guessed due to common cultural references.
  * You can get your passphrases stronger by different means. One is the following:

choose a text in capital letters including or not digits and non alphabetic characters,

shift each letter by a given number but the transformed letter must be a letter (circular shift),
replace each digit by its complement to 9,
keep such as non alphabetic and non digit characters,
downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
reverse the whole result.
#Example:

your text: "BORN IN 2015!", shift 1

1 + 2 + 3 -> "CPSO JO 7984!"

4 "CpSo jO 7984!"

5 "!4897 Oj oSpC"

With longer passphrases it's better to have a small and easy program. Would you write it?
* */
public class PassPhrases {
    public static String playPass(String s, int n) {
        // your code
        String result = "";
        return result;
    }

    @Test
    public void test1() {
        assertEquals("!!!vPz fWpM J", PassPhrases.playPass("I LOVE YOU!!!", 1));
    }

    @Test
    public void test4() {
        assertEquals("4897 NkTrC Hq fT67 GjV Pq aP OqTh gOcE CoPcTi aO",
                PassPhrases.playPass("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015", 2));
    }
}
