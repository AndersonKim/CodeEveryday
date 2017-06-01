import LintCode.P170601;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/1
 * Time:15:30
 */
public class Test {
    public static void main(String[] args) {
        P170601 p170601 = new P170601();
        int[] num = {-1, 0, 1};
        int[] res = p170601.twoSum(num, -1);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
