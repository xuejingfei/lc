package array;


import java.util.Arrays;

public class MajorityElement {


    /**
     * 找出多数元素
     * @param array
     * @return
     */
    public int majorityElement(int[] array) {
        Arrays.sort(array);
        return array[array.length/2];
    }
}
