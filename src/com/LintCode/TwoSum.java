package LintCode;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TwoSum {
    /**
     * number0
     * 2 Sum II - Input array is sorted
     * using binary search from start and end to find right combine
     * @param array
     * @param sum
     * @return
     */
    public int[] TwoSum1(int[] array,int sum){
        int[] result={0,0};
        if (array==null||array.length<=1){
            return result;
        }
        int start=0;
        int end=array.length-1;

        while (start<end){
            long add=(long)(array[start]+array[end]);
            if (add==sum){
                //not zero based index
                result[0]=start+1;
                result[1]=end+1;
                break;
            }else if (add>sum){
                end--;
            }else {
                start++;
            }
        }

        return result;
    }

    /**
     * number1
     * 2 Sum II - Find how many pairs great than sum
     * note this array can be sort and after sort array[end] will always bigger than array[start]
     *
     * @param array
     * @param sum
     * @return
     */
    public int TwoSum2(int[] array, int sum) {
        int result = 0;
        if (array == null || array.length == 0) {
            return result;
        }
        int start = 0;
        int end = array.length - 1;
        Arrays.sort(array);
        while (start < end) {
            int add = array[start] + array[end];
            if (add > sum) {
                //in this case each number on the right of start will add greater than sum
                //because the array is sorted
                result += (end - start);
                end--;
            } else {
                start++;
            }
        }
        return result;
    }

    public int TwoSum2_brutleForce(int[] array, int sum) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                count += array[i] + array[j] > sum ? 1 : 0;
            }
        }
        return count;
    }


    /**
     * number2
     * 2 Sum II - find if have pair add up to sum
     * note that this array is not sorted
     *
     * @param array
     * @param sum
     * @return
     */
    //todo to compute the right answer
    public int[] TwoSum3(int[] array, int sum) {
        int[] result = {0, 0};
        if (array == null || array.length <= 1) {
            return result;
        }
        int[] copy_array = new int[array.length];
        System.arraycopy(array, 0, copy_array, 0, array.length);
        Arrays.sort(copy_array);
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            long add = (long) (copy_array[start] + copy_array[end]);
            if (add == sum) {
                result[0] = start;
                result[1] = end;
                break;
            } else if (add > sum) {
                end--;
            } else {
                start++;
            }
        }
        //find the pos in origin array
        for (int i = 0; i < array.length; i++) {
            if (copy_array[result[0]] == array[i])
                result[0] = i + 1;
            if (copy_array[result[1]] == array[i])
                result[1] = i + 1;
        }

        return result;
    }
    @Test
    public void testTwoSum1() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3, 4};
        int sum1 = 8;
        int sum2=5;
        TwoSum twoSum= new TwoSum();
        // int[] result1=twoSum.TwoSum3(array1,sum1);
        int[] result2 = twoSum.TwoSum3(array2, sum2);
        // assertThat(result1,is(new int[]{0, 0}));
        assertThat(result2, is(new int[]{1,4}));
    }
}
