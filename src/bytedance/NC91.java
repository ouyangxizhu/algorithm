package bytedance;

import util.IntArrUtil;

public class NC91 {
    /**
     * retrun the longest increasing subsequence
     * 最后一个，以arr[i]结尾的最长递增子序列
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return generateResult(arr, dp);
    }

    private int[] generateResult(int[] arr, int[] dp) {
        int maxIndex = 0;
        int startIndex = 0;

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
            if (dp[i] == 1 && dp[i] < dp[startIndex]) {
                startIndex = i;
            }
        }
        int[] result = new int[dp[maxIndex]];
        result[0] = arr[startIndex];
        result[result.length - 1] = arr[maxIndex];
        for (int i = startIndex; i < arr.length; i++) {
            if (result[dp[i] - 1] == 0) {
                result[dp[i] - 1] = arr[i];
            } else if (arr[i] < result[dp[i] - 1] && arr[i] > result[dp[i] - 1]) {
                result[dp[i] - 1] = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 8, 9, 6, 4};
        IntArrUtil.printArr(new NC91().LIS(a));
    }
}
