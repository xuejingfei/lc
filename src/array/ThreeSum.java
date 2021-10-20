package array;

import java.util.*;

public class ThreeSum {

    /**
     * 排序+双指针
     * 时间复杂度O(n^2)
     * 空间复杂度O(logN)
     * @param nums
     * @return
     */
    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0;first <n;first++) {
            if (first>0 && nums[first] == nums[first-1]) {
                continue;
            }
            int target = -nums[first];
            int third = n-1;
            for (int second = first+1;second<n;second++) {
                if (second>0 && nums[second] == nums[second-1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);
                    ans.add(list);
                }
            }
        }
        return ans;

    }
}
