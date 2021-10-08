package array;

public class SortArrayByParity {


    /**
     * left 表示已处理数组的尾部，right 表示已处理数组的头部
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * 保证顺序
     * @param nums
     */
    public int[] sortArrayByParity2(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] % 2 != 0) { //是奇数
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        return nums;
    }


    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * 不保证顺序
     * @param nums
     * @return
     */
    public int[] sortArrayByParity3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }
        return nums;
    }
}
