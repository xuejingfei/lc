package array;

public class RotateArray {

    /**
     * 旋转数组
     * @param nums
     */
    public void rotateArray(int[] nums,int k) {
        int length = nums.length;
        int kth = k % length;
        revertArray(nums,0,length-1);
        revertArray(nums,0,kth-1);
        revertArray(nums,kth,length-1);
    }

    private void revertArray(int[] array,int start,int end) {
        while(start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end -- ;
        }
    }

}
