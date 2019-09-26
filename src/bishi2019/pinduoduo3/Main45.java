package bishi2019.pinduoduo3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main45 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        k = k - 1;
        int nn = n;
        int mm = m;
        int res = n * m;
        while (k-- != 0) {
            if ((nn - 1) * mm > nn * (mm - 1)) {
                res = (nn - 1) * mm;
                nn--;
            } else {
                res = nn * (mm - 1);
                mm--;
            }
        }
        System.out.println(res * 2);
    }

}
