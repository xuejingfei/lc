package singleInvokeStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {


    /**
     * 每日温度
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty()&& temperatures[stack.peek()] < temperature) {
                int preIndex = stack.pop();
                ans[preIndex] = i-preIndex;
            }
            stack.push(i);
        }

        return ans;
    }
}
