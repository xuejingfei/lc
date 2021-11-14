package singleInvokeStack;

import java.util.Stack;

public class Trap {

    /**
     * 接雨水
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<height.length;i++) {
            while (!stack.isEmpty()&&height[i] > height[stack.peek()]) {
                int topIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i-left-1;
                int currHeight = Math.min(height[left],height[i])-height[topIndex];
                ans += currHeight * currWidth;
            }
            stack.push(i);
        }

        return ans;
    }
}
