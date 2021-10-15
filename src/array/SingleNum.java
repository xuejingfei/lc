package array;

public class SingleNum {


    /**
     * 数组中保存的数均出现2次，只有一个出现一次，求出那一次
     * a^0 = a
     * a^a = 0
     * @param nums
     * @return
     */
    public int singleNum(int[] nums) {
        int single = 0;
        for (int num:nums) {
            single ^= num;
        }
        return single;
    }
}
