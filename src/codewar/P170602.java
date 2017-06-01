package codewar;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/2
 * Time:7:30
 */
public class P170602 {
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
}
