package bishi2019.pinduoduo;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++){
            int num = sc.nextInt();
            for (int j = 0;j< num; j++){
                sb.append(i);
            }
        }
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a = m > n ? n :m;
        int b = m > n ? m :n;
        String stra = sb.substring(0, a);
        String strb = sb.substring(a, a + b);
        long lona = Long.valueOf(stra);
        long lonb = Long.valueOf(strb);
        System.out.println(BigInteger.valueOf(lona).multiply(BigInteger.valueOf(lonb)));
    }
}
