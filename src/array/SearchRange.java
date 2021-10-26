package array;

public class SearchRange {

    public int[] searchRange(int[] nums,int target) {
        int start = searchLow(nums,target);
        int end = searchHigh(nums,target);
        if (end < start) {
            return new int[]{-1,-1};
        }
        return new int[]{start,end};
    }

    public int searchLow(int[] nums,int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int middle = low + ((high - low)>>1);
            if (target <=nums[middle]) {
                high = middle - 1;
            } else {
                low = middle+1;
            }
        }
        return low;
    }

    public int searchHigh(int[] nums,int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int middle = low + ((high - low)>>1);
            if (target >= nums[middle] ) {
                low = middle +1;
            } else {
                high = middle-1;
            }
        }
        return high;
    }

}
