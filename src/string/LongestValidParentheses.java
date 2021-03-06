package string;

public class LongestValidParentheses {


    /**
     * 最长有效括号
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for(int i =0;i<s.length();i++){
             if (s.charAt(i) == '(') {
                 left++;
             }else {
                 right++;
             }
             if (left == right) {
                 maxLength = Math.max(maxLength,right*2);
             } else if (right > left) {
                left = right = 0;
             }
        }
        left = right = 0;
        for(int i = s.length()-1;i>=0;i--) {
            if (s.charAt(i) == '(') {
                left++;
            }else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength,right*2);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLength;
    }
}
