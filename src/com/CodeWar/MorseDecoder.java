package com.CodeWar;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * simple decoder of morse code
 * https://www.com.CodeWars.com/kata/decode-the-morse-code/train/java
 */
public class MorseDecoder {
    static Map<String, String> deCodeTable = new HashMap<String, String>();

    //todo using double array solve this problem
    /*static String[][] decodeTable={
            {".-", "A"},
            {"-...", "B"},
    }*/
    public static void initDecodeTable() {
        deCodeTable.put(".-", "A");
        deCodeTable.put("-...", "B");
        deCodeTable.put("-.-.", "C");
        deCodeTable.put("-..", "D");
        deCodeTable.put(".", "E");
        deCodeTable.put("..-.", "F");
        deCodeTable.put("--.", "G");
        deCodeTable.put("....", "H");
        deCodeTable.put("..", "I");
        deCodeTable.put(".---", "J");
        deCodeTable.put("-.-", "K");
        deCodeTable.put(".-..", "L");
        deCodeTable.put("--", "M");
        deCodeTable.put("-.", "N");
        deCodeTable.put("---", "O");
        deCodeTable.put(".--.", "P");
        deCodeTable.put("--.-", "Q");
        deCodeTable.put(".-.", "R");
        deCodeTable.put("...", "S");
        deCodeTable.put("-", "T");
        deCodeTable.put("..-", "U");

        deCodeTable.put("...-", "V");
        deCodeTable.put(".--", "W");
        deCodeTable.put("-..-", "X");
        deCodeTable.put("-.--", "Y");
        deCodeTable.put("--..", "Z");

        deCodeTable.put(".----", "1");
        deCodeTable.put("..---", "2");
        deCodeTable.put("...--", "3");
        deCodeTable.put("....-", "4");
        deCodeTable.put(".....", "5");
        deCodeTable.put("-....", "6");
        deCodeTable.put("--...", "7");
        deCodeTable.put("---..", "8");
        deCodeTable.put("----.", "9");
        deCodeTable.put("-----", "0");
        deCodeTable.put(" ", " ");
    }

    public static String getCode(String morseCode) {
        StringBuffer deCode = new StringBuffer();

        //build words separator
        morseCode = morseCode.replace("   ", "=");
        //build  char separator
        morseCode = morseCode.replace(" ", "!");
        //solve words
        String[] words = morseCode.split("=");
        for (String word : words) {
            //solve char
            String[] code = word.split("!");
            for (String codeUnit : code) {
                deCode.append(deCodeTable.get(codeUnit));
            }
            //append space between words
            deCode.append(" ");
        }
        //cut final space from decode
        return deCode.toString().trim();
    }

    @Test
    public void test() {
        MorseDecoder m = new MorseDecoder();
        initDecodeTable();
        System.out.println(getCode(".... . -.--   .--- ..- -.. ."));
    }
}
