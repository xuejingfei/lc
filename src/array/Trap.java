package array;

import java.util.Stack;

public class Trap {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        if (height == null || height.length<3) {
            return ans;
        }
        for(int i=0;i<height.length;i++) {
            while (!stack.isEmpty()&&height[i] > height[stack.peek()]) {
                int topIndex = stack.pop();
                while (!stack.isEmpty() && height[topIndex] == height[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int temple = height[stack.peek()];
                    int hi = Math.min((temple-height[topIndex]),(height[i]-height[topIndex]));
                    ans += hi *(i-stack.peek()-1);
                }
            }
            stack.push(i);
        }

        return ans;
    }
}
