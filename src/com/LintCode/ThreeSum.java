package LintCode;

import java.util.ArrayList;

//todo unfinished codes
public class ThreeSum {
    /*
    Given an array S of n integers,
    find three integers in S such that the sum is closest to a given number, target.
    Return the sum of the three integers.
    Note
    You may assume that each input would have exactly one solution.
    Example
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    Tags Expand
    Two Pointers Sort Array
    */

    public int threeSumClosest(int[] num, int target) {
        int result = Integer.MAX_VALUE;
        return result;
    }


    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.
    Example
    For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    Note
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
    Tags Expand
    Two Pointers Sort Array Facebook
    */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (numbers == null && numbers.length <= 2) {// Length at least >= 3
            return rst;
        }


        return rst;
    }
}
