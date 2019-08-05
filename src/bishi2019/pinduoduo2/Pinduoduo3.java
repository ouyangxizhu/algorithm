package bishi2019.pinduoduo2;


import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo3 {
    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        new ConcurrentHashMap<>();
        new LinkedBlockingQueue<>();

        Scanner scan=new Scanner(System.in);
        String s = scan.nextLine();
        String[] s1 = s.split(" ");
        int m = Integer.valueOf(s1[0]);
        int n = Integer.valueOf(s1[1]);

        int[] a = new int[m];
        String s2 = scan.nextLine();
        String[] s3 = s2.split(" ");
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(s3[i]);
        }
        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            sum += a[i];
        }
        System.out.println(sum);

    }
}
