package qiuzhao2019.zjitiaodong;

import java.util.Arrays;
import java.util.Scanner;

public class ZiJieTiaoDong3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] sp = sc.nextLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(sp[i]);
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]){
                res[i] = res[i - 1] + 1;
            }
        }
        long sum = res[n - 1];
        for (int i = n - 1; i >= 1; i--) {
            if (a[i] < a[i - 1]){
                res[i - 1] = Math.max(res[i - 1], res[i] + 1);
            }
            sum += res[i - 1];

        }
        System.out.println(sum * 100);

    }
}
