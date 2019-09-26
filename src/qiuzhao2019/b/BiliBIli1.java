package qiuzhao2019.b;

import java.util.Scanner;

public class BiliBIli1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(helper(s1, s2));
    }

    private static long helper(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= len2; j++) {
                dp[0][j] = j;
                int insert = dp[i][j - 1] + 1;
                int delete = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1];
                if (c1[i - 1] != c2[j - 1]) {
                    replace += 1;

                }
                dp[i][j] = Math.min(replace,Math.min(insert, delete));

            }

        }
        return dp[len1][len2];
    }
}
