package leetcode.maimaigupiao;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 示例:

 输入: [1,2,3,0,2]
 输出: 3
 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * Created by ouyangxizhu on 2019/4/22.
 */
public class ThreeZeroNine {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0)
            return 0;
        int[] dp1 = new int[len];//第i天以及以前 持有股票的最大收益
        int[] dp2 = new int[len];//第i天以及以前 不存在股票的最大收益
        int[] dp3 = new int[len];//第i天 为冷冻期的最大收益
        dp1[0] = - prices[0];
        dp2[0] = 0;
        dp3[0] = 0;
        for (int i = 1; i < len; i++){
            dp1[i] = Math.max(dp1[ i - 1], dp3[i - 1] - prices[i]);
            dp2[i] = Math.max(dp2[ i - 1], dp1[i - 1] + prices[i]);
            dp3[i] = Math.max(dp2[ i - 1], dp3[i - 1]);
        }
        return Math.max(dp2[len-1],dp3[len-1]);
    }
    public int maxProfit1(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        //三个dp数组
        //一个存第i天前(包括第i天)最后操作是冷冻期的最高收益
        //一个存第i天前(包括第i天)最后操作是买入的最高收益
        //一个存第i天前(包括第i天)最后操作是卖出的最高收益
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        int[] dp3 = new int[prices.length];
        dp1[0] = 0;
        dp2[0] = -prices[0];
        dp3[0] = 0;

        for(int i = 1; i < prices.length; i++){
            dp1[i] = Math.max(dp1[i - 1], dp3[i - 1]);
            dp2[i] = Math.max(dp1[i - 1] - prices[i], dp2[i - 1]);
            dp3[i] = Math.max(dp2[i - 1] + prices[i], dp3[i - 1]);
        }
        //最后的操作一定是卖出
        return dp3[prices.length - 1];
    }
}
