package bytedance;

public class NC7 {
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int result = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] - prices[i - 1];
            result = Math.max(result, sum);
            sum = Math.max(0, sum);
        }
        return result;
    }

    public int maxProfit1 (int[] prices) {
        int minn = prices[0];
        int ans = 0;
        for(int i = 0 ; i < prices.length ; i++)
        {
            minn = Math.min(minn,prices[i]);
            ans = Math.max(ans,prices[i]-minn);
        }
        return ans;
    }
}
