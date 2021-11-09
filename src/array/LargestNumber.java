package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    /**
     * 取数组最大数
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num:nums) {
            list.add(num+"");
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        });

        StringBuilder ans = new StringBuilder();
        for (String s:list) {
            ans.append(s);
        }
        if (ans.charAt(0) == '0') return "0";
        return ans.toString();
    }




}
