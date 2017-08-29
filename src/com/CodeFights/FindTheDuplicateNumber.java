package com.CodeFights;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * You can choose to solve this problem without obeying the O(1) memory constraint. Once you have solved it,
 * you will be able to look at other people's solutions!
 * <p>
 * If you do want to solve it within the memory limit, the restrictions on the values a[i] are critical in this problem.
 * Changing the array in place doesn't require extra memory.
 * To solve this problem ignoring the constraint, make an array seen of size a.length filled with zeros.
 * <p>
 * <p>
 * When scanning the array and you encounter the number n,
 * check if the corresponding element of seen is still zero
 * (i.e. seen[n] in languages that use a 1-based index, or seen[n-1] in languages that use a 0-based index.).
 * If it the corresponding element is zero, change it to non-zero.
 * If the corresponding element isn't zero, return n as you have encountered a duplicate.
 * <p>
 * <p>
 * The constraint 1 ≤ a[i] ≤ a.length guarantees that the value a[i] is also a valid 1-based index in that array.
 * <p>
 * <p>
 * Use the value a[i] to change the element with a 1-based index of a[i] to -a[i].
 * You know that a negative number cannot appear in the array.
 * <p>
 * <p>
 * <p>
 * When reading in a[i], check the value of a[abs(a[i])] before changing it.
 * If a[abs(a[i])] < 0, then this position has already been changed and a[i] is a duplicate.
 */
public class FindTheDuplicateNumber {
    /**
     * find the first duplicate number that match following condition:
     * -first
     * -duplicated
     * -has the min distance between
     *
     * @param array numbers input
     * @return the duplicate number or -1 if no duplicate number
     */
    public int firstDuplicate(int[] array) {
        //two kind of solution
        //first:
        //double roll the array and find duplicate numbers also note their distance
        //second:
        //sort array located duplicate number then calculate their distance


        /*second*/
        //store duplicate number and distance
        Map<Integer, Integer> numAndDis = new Hashtable<Integer, Integer>();
        //default number
        int result = -1;
        //loop to set numAndDis
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    //have the same key
                    if (numAndDis.containsKey(array[i])) {
                        int dis1 = numAndDis.get(array[i]);
                        int dis2 = Math.abs(i - j + 1);
                        numAndDis.put(array[i], dis1 > dis2 ? dis2 : dis1);
                    } else {
                        numAndDis.put(array[i],Math.abs(i-j+1));
                    }
                }


            }
        }
        //get the min distance duplicate number
        if (numAndDis.isEmpty()) {
            return result;
        } else {
            //big--------------small
            //{99,28,...,min2,min1}
            Integer min1 = array.length;
            Integer min2=array.length;
            Integer subResult1=-1;
            Integer subResult2=-1;
            Iterator<Map.Entry<Integer, Integer>> it = numAndDis.entrySet().iterator();

            //find min distance
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (min1 > entry.getValue()) {
                    min1=entry.getValue();
                    subResult1 = entry.getKey();
                }
            }
            //find if same one
            Iterator<Map.Entry<Integer, Integer>> it1 = numAndDis.entrySet().iterator();
            while (it1.hasNext()) {
                Map.Entry<Integer, Integer> entry = it1.next();
                if (min1 == entry.getValue() && subResult1 != entry.getKey()) {

                    min2 = entry.getValue();
                    subResult2 = entry.getKey();


                }
            }
            //have the same distance result should compare
            if (subResult2 != -1) {
                //the first appear number
                for (int key : array) {
                    if (key == subResult1) {
                        result = subResult1;
                        break;
                    }
                    if (key == subResult2) {
                        result = subResult2;
                        break;
                    }

                }
            }else {
                result = subResult1;
            }

        }
        return result;
    }

    public int firstDuplicateAI(int[] a) {
        int result = -1;
        int[] arr = new int[a.length];
        Arrays.fill(arr, -1);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    arr[i] = Math.abs(i - j + 1);
                    break;
                }
            }
        }
        System.out.println("never settle");
        return result;
    }


}