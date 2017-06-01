package codewar;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/2
 * Time:7:30
 */
public class P170602 {
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
}
