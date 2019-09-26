package bishi2019.pinduoduo3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int max = a[a.length - 1];
        int m = 1;
        for (int i = 0; i < a.length; i++) {
            m = m * a[i];
        }
        double aa = 1.0 / m;
        double res = aa;
        for (int i = 2; i < max + 1; i++) {
            int index =0;
            double aa1 = 1.0;
            for (int j = 0; j < n; j++) {
                if (a[j] >= i) {
                    index = j;
                    break;
                }
            }
            for (int j = index; j < n; j++) {
                aa1 = aa1 * i / (1.0 * a[j]);

            }
            res = res + i * (aa1 - aa);
            aa = aa1;
        }
        System.out.println(String.format("%.2f", res));

    }

}
