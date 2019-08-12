package leetcode.dynamicprogramming;

public class Leetcode_1149 {
    /**
     * Analysis
     * 由于石头拿走还能放回去，因此可以简单地把所有石头看作两堆
     * 假设总重量为 sum, 则问题转化为背包问题：
     * 如何使两堆石头总重量接近 sum / 2
     * 定义：
     *
     * dp[i] 背包容量限制为 i 时能够装载的最大石块总重量
     * curStone 存在最优解 dp[i] 时需要考虑的下一块石块重量

     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int cap = sum >> 1;
        int[] dp = new int[cap + 1];
        for (int i = 0; i < stones.length; i++) {
            int curStone = stones[i];
            for (int j = cap; j >= curStone; j--) {
                dp[j] = Math.max(dp[j], dp[j - curStone] + curStone);
            }
        }
        return sum - 2 * dp[cap];
    }
}
