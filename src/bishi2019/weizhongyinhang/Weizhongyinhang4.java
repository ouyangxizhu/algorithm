package bishi2019.weizhongyinhang;

import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/11.
 */
public class Weizhongyinhang4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long m = sc.nextLong();
        long res = n * k;

        System.out.println((res + m - 1) / m);
    }
}
