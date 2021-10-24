package array;

public class NextPermutation {


    /**
     * 获取下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i>=0 && nums[i]>=nums[i+1]) {
            i--;
        }
        if (i>=0) {
            int j = nums.length-1;
            while (j>=0 && nums[i]>=nums[j]) {
                j--;
            }
            swap(nums,i,j);
        }

        revert(nums,i+1);

    }

    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void revert(int[] nums,int start) {
        int left = start;
        int right = nums.length-1;
        while (left<right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }

}
