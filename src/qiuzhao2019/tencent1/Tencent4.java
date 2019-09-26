package qiuzhao2019.tencent1;

import java.util.Scanner;

public class Tencent4 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] sum = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            s += a[i];
            sum[i] = s;
        }
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];//最小值
        for (int i = 0; i < n; i++) {
            dp[i][i] = a[i];
            res = Math.max(res, dp[i][i] * a[i]);
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], a[j]);
                res = Math.max(res, dp[i][j] * (sum[j] - sum[i] + a[i]));
            }
        }
        System.out.println(res);

    }
}
