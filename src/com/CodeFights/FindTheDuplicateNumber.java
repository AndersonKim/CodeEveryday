import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

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
                    numAndDis.put(array[i], Math.abs(i - j + 1));
                    break;
                }
            }
        }
        //get the min distance duplicate number
        if (numAndDis.isEmpty()) {
            return result;
        } else {
            Integer min = array.length;
            Iterator<Map.Entry<Integer, Integer>> it = numAndDis.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (min > entry.getValue()) {
                    min = entry.getValue();
                    result = entry.getKey();
                }
            }
        }
        System.out.println("not yet");
        return result;
    }
}
