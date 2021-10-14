package string;


public class LongestPalindrome {

    /**
     * 获取最长回文字符串
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) return "";
        int start = 0;
        int end = 0;
        for(int i =0;i<s.length();i++) {
            int length1 = expandAroundCenter(s,i,i);
            int length2 = expandAroundCenter(s,i,i+1);
            int maxLength = Math.max(length1,length2);
            if (maxLength > (end-start)) {
                start = i - (maxLength-1)/2;
                end = i + maxLength/2;
            }
        }
        return s.substring(start,end+1);

    }


    /**
     * 中心向外扩展(满足a, aa，bab的情况)
     * @param s
     * @param i
     * @param j
     * @return
     */
    public int expandAroundCenter(String s,int i,int j) {
        while(i<=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;j++;
        }
        return j-i-1;
    }
}
