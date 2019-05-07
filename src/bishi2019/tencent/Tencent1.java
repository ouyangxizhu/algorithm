package bishi2019.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/5.
 */
public class Tencent1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i< n; i ++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int sum = 0;
        int res = 0;
        if (a[0] != 1){
            System.out.println( -1);
        }else{
            while(true){
                if(sum >= m){
                    System.out.println(res);
                    return;
                }
                for (int i = n - 1; i >= 0; i--){
                    if (a[i] <= sum + 1){
                        sum += a[i];
                        res ++;
                        break;
                    }
                }
            }


        }


    }
}
