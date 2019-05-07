package bishi2019.pinduoduo;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int[] res = new int[n/2];
        for (int i = 0; i < n/2; i++){
            res[i] = a[i] + a[n - 1 - i];
        }
        Arrays.sort(res);
        System.out.println(res[n/2 - 1] - res[0]);
    }
}
