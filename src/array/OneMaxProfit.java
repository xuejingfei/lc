package array;

public class OneMaxProfit {


    /**
     * 暴力解决法（只能交易一次）
     * 时间复杂度O(n*2)
     * 空间复杂度O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=0;i<prices.length;i++) {
            for (int j=i;j<prices.length;j++){
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 一次遍历(找出最低价的一天)（只能交易一次）
     * 找出最低价
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0;i<prices.length;i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

}
