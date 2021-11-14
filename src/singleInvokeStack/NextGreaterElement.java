package singleInvokeStack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {


    /**
     * 下一个更大元素(496)
     * 时间复杂度 O(m+n)
     * 空间复杂度  O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1,int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<nums2.length;i++) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek()<num) {
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        int[] ans = new int[nums1.length];
        for (int i=0;i<nums1.length;i++) {
            ans[i] = map.get(nums1[i]) == null ?-1:map.get(nums1[i]);
        }
        return ans;
    }
}
