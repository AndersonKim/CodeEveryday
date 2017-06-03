package codewar;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/3
 * Time:15:03
 */
public class P170603 {
    public static String interlace(final String first, final String second) {
        String result = "";
        //清洗space键
        String a = "", b = "";
        a = clean_space(first);
        b = clean_space(second);
        //根据去除空格键后的长短处理
        ////等长情况
        if (a.length() == b.length()) {
            result = mix_equal_string(a, b, result);
        }////不一样长
        else {
            //找出短的一方
            String _shot = a.length() > b.length() ? b : a;
            String _long = a.length() > b.length() ? a : b;
            //补充短的一方到长的一方一样长
            int time = _long.length() / _shot.length() + 1;
            //考虑到原来就有的第一倍
            for (int i = 0; i < time - 1; i++) {
                _shot += _shot;
            }
            //从短的字符串取得与长的一方等长的字符串
            _shot = _shot.substring(0, _long.length());
            //问题转化为相同长度字符串的混合
            result = mix_equal_string(_long, _shot, result);
        }
        return result;
    }

    public static String mix_equal_string(String a, String b, String result) {
        for (int i = 0; i < a.length(); i++) {
            String temp1 = String.valueOf(a.charAt(i));
            result = result.concat(temp1);
            String temp2 = String.valueOf(b.charAt(i));
            result = result.concat(temp2);
        }
        return result;
    }

    public static String clean_space(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                continue;
            } else {
                //使用concat函数的坑：需要二次调用=才可以将值赋予源字符串
                result = result.concat(String.valueOf(str.charAt(i)));
            }

        }
        return result;
    }

    public static String interlace1(final String first, final String second) {
        String result = "";
        // mix string parameters into result
        return result;
    }
}
