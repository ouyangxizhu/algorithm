package bytedance;

public class NC19 {
    /**
     * max sum of the subarray
     *遇到这种动态公式非常明显的题，直接考虑动态规划，并且列出转移方程
     * 设置动态数组dp[i]：下标为i处之前的最大累加和(可能不包括自己也可能包括自己)以下为转移方程
     *
     * 初始化dp[0] = arr[0]
     * dp[i-1] > 0 -> dp[i] = dp[i-1] + arr[i]
     * dp[i-1] <= 0 -> dp[i] = arr[i]
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + arr[i] : arr[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxsumofSubarray1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = sum > 0 ? sum + arr[i] : arr[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(new NC19().maxsumofSubarray(a));
    }
}
