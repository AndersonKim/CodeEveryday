/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/21
 * Time:21:48
 */
public class ForAndForeach {
    public static String[] strlist = {"qwe", "qwe", "asd", "zxc", "asd", "zxc"};

    public long countFor() {
        long s = System.currentTimeMillis();
        StringBuffer sum = new StringBuffer();
        for (int t = 0; t < 100000; t++) {
            for (int i = 0; i < strlist.length; i++) {
                sum.append(strlist[i]);
            }
        }

        long e = System.currentTimeMillis();
        return (e - s);
    }

    public long countForeach() {
        long s = System.currentTimeMillis();
        StringBuffer sum = new StringBuffer();
        for (int t = 0; t < 100000; t++) {
            for (String str : strlist) {
                sum.append(str);
            }
        }
        long e = System.currentTimeMillis();
        return (e - s);
    }
}
