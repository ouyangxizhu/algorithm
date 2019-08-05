package bishi2019.bytebalance;


import java.util.Scanner;


public class ByteBlance3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        int[] coins = new int[]{150, 200, 350};
        int[] ans = new int[t];
        int m = t;
        while(t-- > 0){


            int a = Integer.valueOf(sc.nextLine());
            int[] res = new int[]{Integer.MAX_VALUE};
            if(a % 150 == 0 || a% 200 == 0|| a% 350 == 0|| a% 500 == 0 || a% 550 == 0 || a% 700 == 0)
                ans[m - t - 1] = 0;
            else{
                count(res,coins, a);
                ans[m - t - 1] = res[0];
            }


        }
        for(int i: ans){
            System.out.println(i);
        }


    }
    private static int count(int[] res, int[] coins, int a){
        if(a >= 0) res[0] = Math.min(res[0], a);
        if(a <= 150) return a;
        for (int i = 0; i < coins.length; i++) {
            count(res, coins,a - coins[i]);
        }
        return res[0];

    }
}
