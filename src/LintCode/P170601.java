package LintCode;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/1
 * Time:15:25
 */

import java.util.Arrays;

/**
 * Given nums = [2, 7, 11, 15], target = 9
 * return [1, 2]
 */
public class P170601 {

    public boolean getXO(String str) {
        boolean same = true;
        int x = 0, o = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x' || str.charAt(i) == 'X') {
                x++;
            }
            if (str.charAt(i) == 'o' || str.charAt(i) == 'O') {
                o++;
            }
        }
        if (x == o) same = true;
        else same = false;
        return same;
    }

    public boolean getXO1(String str) {
        //使用原生函数替换优于自制循环
        str = str.toLowerCase();
        return str.replace("o", "").length() == str.replace("x", "").length();
    }

    public int sumOfElements(int matrix[][]) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res += matrix[i][j];
            }
        }
        return res;
    }

    public int sumOfElements1(int matrix[][]) {

        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
        //return Arrays.stream(matrix).flatMapToInt().sum();
    }

    public int[] twoSum(int[] nums, int target) {
        //标注检索的最大位置
        int max_pos = nums.length - 1;
        int indexI = 0, indexJ = 0;
        if (target > 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (target <= nums[i]) {
                    max_pos = i;
                }
            }
        } else {
            max_pos = nums.length - 1;
        }

        for (int i = 0; i <= max_pos; i++) {
            for (int j = i + 1; j <= max_pos; j++) {
                if (nums[i] + nums[j] == target) {
                    indexI = i;
                    indexJ = j;
                }
            }
        }
        int res[] = {indexI + 1, indexJ + 1};
        return res;
    }
}
