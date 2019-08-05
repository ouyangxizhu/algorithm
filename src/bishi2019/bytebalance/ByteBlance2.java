package bishi2019.bytebalance;

import java.util.Scanner;

public class ByteBlance2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        boolean[][] dp = new boolean[s1.length() + 1][s2.length()+ 1];
        dp[s1.length()][s2.length()] = true;
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                boolean tmp = (i < s1.length() && (s2.charAt(j) == s1.charAt(i) || s2.charAt(j) == '.'));
                if(j + 1 < s2.length() && s2.charAt(j +1) == '*'){
                    dp[i][j] = dp[i][j + 2] || tmp && dp[i + 1][j];
                    
                }else{
                    dp[i][j] = tmp && dp[i + 1][j + 1];
                }
            }
        }
       System.out.println(dp[0][0]);

    }
}
