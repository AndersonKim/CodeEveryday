package LintCode;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TwoSum {
    /**
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
    @Test
    public void testTwoSum1(){
        int [] array={1,2,3,4,5,6,7,8,9};
        int sum=8;
        TwoSum twoSum=new TwoSum();
        int[] result=twoSum.TwoSum1(array,sum);
        int[] r={1,7};
        assertThat(result,is(r));
    }
}
