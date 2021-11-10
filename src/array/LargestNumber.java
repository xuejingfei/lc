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


    public String largestNumber1(int[] nums) {
        quickSort(nums,0,nums.length-1);
        StringBuilder ans = new StringBuilder();
        for (int i:nums) {
            ans.append(i);
        }
        if (ans.charAt(0) == '0') return "0";
        return ans.toString();
    }


    public void quickSort(int[] nums,int low,int high) {
        if (low>high) return;
        int i = low;
        int j = high;
        int lowV = nums[low];
        while (i<j) {
            while (compare(nums[j],lowV)&& i<j) {
                j--;
            }

            while (!compare(nums[i],lowV)&& i<j) {
                i++;
            }
            if (i<j) {
                int temple = nums[j];
                nums[j] = nums[i];
                nums[i] = temple;
            }
        }
        nums[low] = nums[i];
        nums[i] = lowV;
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
    }


    public boolean compare(int a,int b) {
        String aValue = a+""+b;
        String bValue = b+"" +a;
        return aValue.compareTo(bValue)>=0;
    }




}
