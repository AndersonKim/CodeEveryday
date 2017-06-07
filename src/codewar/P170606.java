package codewar;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/7
 * Time:12:57
 */
public class P170606 {
    static String encode1(String word) {
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            //lastindexof最后一个位置
            //indeof第一个位置
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }

    public String encode(String word) {
        //组装最终字符
        StringBuffer buffer = new StringBuffer();
        //储存每位的字符是否重复
        boolean[] duplicate = new boolean[word.length()];
        //每次循环判断一位是否重复
        for (int i = 0; i < word.length(); i++) {
            for (int index = 0; index < word.length(); index++) {
                if (i == index) {
                    continue;
                } else {
                    String a = String.valueOf(word.charAt(i));
                    String b = String.valueOf(word.charAt(index));
                    if (a.equalsIgnoreCase(b)) {
                        duplicate[i] = true;
                    }
                }
            }
        }

        for (boolean isDuplicate : duplicate) {
            if (isDuplicate) buffer.append(")");
            else buffer.append("(");
        }
        return buffer.toString();
    }
}
