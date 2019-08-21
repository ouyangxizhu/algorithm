package qiuzhao2019.tencent;

import java.util.Scanner;

public class Tencent4 {
    /*
    6
5 3 8 3 2 5
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]){
                dp[i][0] = dp[i - 1][0];
            }else{
                if (a[i] > a[dp[i - 1][0]])
                    dp[i][0] = i;
                else
                    dp[i][0] = dp[i - 1][0];
            }
        }
        int[] res = new int[n];
        dp[n - 1][1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i + 1] > a[i]) {
                dp[i][1] = dp[i + 1][1];
            }else{
                if(a[i] > a[dp[i + 1][1]])
                    dp[i][1] = i;
                else
                    dp[i][1] = dp[i + 1][1];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res[i] = dp[i][1] - dp[i][0] + 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (dp[i][1] == dp[i][0]){
                res[i] = res[i - 1] + res[i + 1] - 2;
            }
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(res[i] + " ");
        }
        System.out.println(stringBuilder.toString().trim());

    }
}
