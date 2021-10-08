package array;

public class MoveZeros {

    /**
     * 使用双指针
     * 不为0的移动到前部，记录为0的数量，然后再赋值为0
     * @param array
     */
    public void moveZeros(int[] array) {
        int slow = 0;
        int zeroNum = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                array[slow++] = array[fast];
            } else {
                zeroNum++;
            }
        }

        for (int i = array.length - zeroNum; i < array.length; i++) {
            array[i] = 0;
        }
    }


    /**
     * 使用双指针
     * left 表示以处理的尾节点，right 表示未处理的头节点
     * @param array
     */
    public void moveZeros2(int[] array) {
        int n = array.length;
        int left = 0;
        int right = 0;
        while(right<n) {
            if (array[right] != 0) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
            }
            right++;
        }
    }
}
