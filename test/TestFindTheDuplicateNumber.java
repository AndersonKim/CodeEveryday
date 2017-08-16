

import org.junit.Test;

public class TestFindTheDuplicateNumber {
    int[] testcase1 = {8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
    int[] testcase2 = {2, 3, 3, 1, 5, 2};

    @Test
    public void testFirstDuplicate() {
        FindTheDuplicateNumber ffdn = new FindTheDuplicateNumber();
        ffdn.firstDuplicate(testcase1);
    }
}
