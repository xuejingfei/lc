package array;

public class SortArray {

    /**
     * 快速排序
     *
     * @param nums
     */
    public void sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[] nums,int low,int high) {
        if (low>high) return;
        int i = low;
        int j = high;

        int lowV = nums[low];
        while(i<j) {
            while (lowV<=nums[j] && i<j) {
                j--;
            }
            while (lowV>=nums[i] && i<j) {
                i++;
            }

            if (i<j) {
                int temple = nums[j];
                nums[j] = nums[i];
                nums[i] = temple;
            }
        }
        nums[low] = nums[i];
        nums[i] = lowV;
        quickSort(nums,low,j-1);
        quickSort(nums,j+1,high);
    }
}
