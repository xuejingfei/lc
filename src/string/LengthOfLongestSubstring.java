package string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    /**
     * 无重复字符的最长子串
     *
     * @return
     */
    private int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() == 1) return 1;
        int left = 0;
        int right = 0;
        int longestLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (right <s.length()) {
            Character c = s.charAt(right);
            if (map.containsKey(c)) {
                //⚠️ 这边必须要和left取最大值。map.get(c)有可能取最小值（如"abba"）
                left = Math.max(left,map.get(c) + 1);
            }
            map.put(c,right);
            longestLength = Math.max(longestLength,right-left+1);
            right ++;
        }
        return longestLength;
    }

}
