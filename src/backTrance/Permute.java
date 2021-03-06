package backTrance;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    /**
     * 全排列
     * @param nums
     * @return
     */
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backTrance(result,item,nums);
        return result;
    }


    /**
     *
     * @param result 存储结果
     * @param item 保存每一项结果
     * @param nums 原数据
     */
    private void backTrance( List<List<Integer>> result,List<Integer> item,int[] nums) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i =0;i<nums.length;i++) {
            if (item.contains(nums[i])) continue;
            item.add(nums[i]);
            backTrance(result,item,nums);
            item.remove(item.size()-1);
        }
    }
}
