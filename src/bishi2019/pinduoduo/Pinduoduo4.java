package bishi2019.pinduoduo;


import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int l1 = str1.length();
        int l2 = str2.length();
        if(l1 == 0){
            System.out.println(l2);
            return;
        }
        if(l2 == 0){
            System.out.println(l1);
            return;
        }
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i<= l1; i++){
            for (int j = 1; j <= l2; j++){
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] =  dp[i - 1][j - 1];
                }else{
                    dp[i][j] =  Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        System.out.println(dp[l1][l2]);
    }
}
