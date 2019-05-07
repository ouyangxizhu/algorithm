package bishi2019.weizhongyinhang;

import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/11.
 */
public class Weizhongyinhang2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        long res = (n * k + m - 1) / m;
        res = k > res ? k : res;

        System.out.println(res);
    }
}
