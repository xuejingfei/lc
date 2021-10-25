package array;

public class RevertSearch {


    /**
     * 搜索旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums,int target) {
        int slow = 0;
        int high = nums.length-1;
        while (slow<=high) {
            int middle = (slow+high)/2;
            if (nums[middle] == target) return middle;
            if (nums[0] <= nums[middle]) { //升序
                if (target >= nums[0] && target <=nums[middle]) {
                    high = middle -1;
                } else {
                    slow = middle+1;
                }
            } else {
                if (nums[middle] <target && target <= nums[nums.length-1]) {
                    slow = middle+1;
                } else {
                    high = middle-1;
                }
            }
        }
        return -1;
    }
}
