package leetcode.hot_100;

public class Hot_560 {
    /**
     * 思路：
     *  sum[i]表示num[0:i]的子数组和，那么num[i:j]的和等于sum[j] - sum[i]
     *  两层循环遍历sum数组检查 sum[j] - sum[i] == k
     *
     * @param nums 数组
     * @param k 目标和
     * @return 子数组个数
     */

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int ans = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i - 1] + sum[i -1];
        }
        for (int i = 1; i < sum.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(sum[i] - sum[j] == k)
                    ans++;
            }
        }
        return ans;
    }
}
