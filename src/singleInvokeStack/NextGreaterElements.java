package singleInvokeStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i =0;i<2*n-1;i++) {
            while (!stack.isEmpty() && nums[i%n] > nums[stack.peek()]) {
                ret[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }
        return ret;
    }
}
