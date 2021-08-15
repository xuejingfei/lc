package array;

public class MoreMaxProfit {


    /**
     * 获取最大利润(可交易多次)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1;i<prices.length;i++) {
            ans+=Math.max(0,prices[i]-prices[i-1]);
        }
        return ans;
    }



}
