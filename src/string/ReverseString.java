package string;

public class ReverseString {


    /**
     * 反转字符串
     * @param chars
     */
    public void reverseString(char[] chars) {
        int left = 0;int right = chars.length-1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left ++;
            right --;
        }
    }
}
