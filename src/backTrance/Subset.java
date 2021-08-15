package backTrance;

import java.util.ArrayList;
import java.util.List;

public class Subset {


    /**
     * 生成所有的子集
     * @return
     */
    public List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0,nums,result,temp);
        return result;
    }


    public void dfs(int index,int[] nums,List<List<Integer>> result,List<Integer> temp){
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs(index+1,nums,result,temp);
        temp.remove(temp.size()-1);
        dfs(index+1,nums,result,temp);
    }
}
