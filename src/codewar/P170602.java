package codewar;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/2
 * Time:7:30
 */
public class P170602 {
    public static String toJadenCase(String phrase) {
        // TODO put your code below this comment
        if (phrase == null || phrase.equals(""))
            return null;
        else {
            String result = "";
            String[] words = phrase.split(" ");
            for (String word : words) {
                String firstChar = String.valueOf(word.charAt(0));
                firstChar = firstChar.toUpperCase();
                word = firstChar + word.substring(1);
                result += " " + word;
            }
            return result.trim();
        }
    }

    public static String decodeResistorColors(String bands) {
        /**
         * black: 0, brown: 1, red: 2, orange: 3, yellow: 4,
         * green: 5, blue: 6, violet: 7, gray: 8, white: 9
         */
        int n[] = {0, 0, 0};
        int d = 0;
        String[] strs = bands.split(" ");
        //tolerance
        if (strs.length == 4) {
            switch (strs[3]) {
                case "gold":
                    d = 5;
                    break;
                case "silver":
                    d = 10;
                    break;
            }
        } else {
            d = 20;
        }
        //number
        for (int i = 0; i < 3; i++) {
            switch (strs[i]) {
                case "black":
                    n[i] = 0;
                    break;
                case "brown":
                    n[i] = 1;
                    break;
                case "red":
                    n[i] = 2;
                    break;
                case "orange":
                    n[i] = 3;
                    break;
                case "yellow":
                    n[i] = 4;
                    break;
                case "green":
                    n[i] = 5;
                    break;
                case "blue":
                    n[i] = 6;
                    break;
                case "violet":
                    n[i] = 7;
                    break;
                case "gray":
                    n[i] = 8;
                    break;
                case "white":
                    n[i] = 9;
                    break;
            }
        }
        //count
        double sum = (n[0] * 10 + n[1]) * Math.pow(10, n[2]);
        double res = 0.0;
        String result = "";
        if (sum < 1000) {
            res = sum;
            //使用强制转换解决小数点问题
            int intValue = (int) res;
            String temp = "";
            if (res > intValue) {
                temp = String.valueOf(res);
            } else {
                temp = String.valueOf(intValue);
            }
            result = temp + " ohms, " + d + "%";
        } else if (sum < 1000000 && sum >= 1000) {
            res = sum / 1000;
            //使用强制转换解决小数点问题
            int intValue = (int) res;
            String temp = "";
            if (res > intValue) {
                temp = String.valueOf(res);
            } else {
                temp = String.valueOf(intValue);
            }
            result = temp + "k ohms, " + d + "%";
        } else {
            res = sum / 1000000;
            int intValue = (int) res;
            String temp = "";
            if (res > intValue) {
                temp = String.valueOf(res);
            } else {
                temp = String.valueOf(intValue);
            }
            result = temp + "M ohms, " + d + "%";
        }


        return result;
    }

    public static String decodeResistorColors1(String bands) {
        String result = "";
        return result;
    }

    public static String histogram(final int results[]) {
        String res = "";
        for (int i = results.length - 1; i >= 0; i--) {
            int time = results[i];
            res = res.concat(i + 1 + "|");
            for (int j = 0; j < time; j++) {
                res = res.concat("#");
            }
            if (time != 0) {
                res = res.concat(" " + time + "\n");
            } else {
                res = res.concat("\n");
            }

        }
        return res;
    }

    public static String histogram1(final int results[]) {
        String result = "";
        for (int i = results.length - 1; i >= 0; i--) {
            result += i + 1 + "|";
            //使用if提前剪枝减少无效遍历
            if (results[i] == 0) result += "\n";
            else {
                for (int x = results[i]; x > 0; x--) {
                    result += "#";
                }
                result += " " + results[i] + "\n";
            }
        }
        return result;
    }

    public static String covfefe(String tweet) {
        String temp = "covfefe";
        String res = null;
        if (tweet.contains("coverage")) {
            res = tweet.replace("coverage", temp);
        } else {
            res = tweet.concat(" " + temp);
        }
        return res;
    }

    public static String covfefe1(String tweet) {
        //使用A?b:c简化if/else的判断逻辑
        return tweet.contains("coverage") ?
                tweet.replace("coverage", "covfefe") :
                tweet + " covfefe";
    }

    public String toJadenCase1(String phrase) {
        if (phrase == null || phrase.equals("")) return null;

        char[] array = phrase.toCharArray();

        for (int x = 0; x < array.length; x++) {
            //使用前向指针确定单词首字母
            if (x == 0 || array[x - 1] == ' ') {
                array[x] = Character.toUpperCase(array[x]);
            }
        }

        return new String(array);
    }
}
