package array;

public class BinarySearch {


    /**
     * 二分查找哦
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums,int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int middle = (low + high)/2;
            if (nums[middle] > target) {
                high = middle-1;
            }else if (nums[middle] < target) {
                low = middle+1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
