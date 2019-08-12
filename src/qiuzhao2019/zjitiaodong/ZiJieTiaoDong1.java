package qiuzhao2019.zjitiaodong;

import java.util.Arrays;
import java.util.Scanner;

public class ZiJieTiaoDong1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] sp = s.split(" ");
            a[i] = Integer.valueOf(sp[0]) * 60 + Integer.valueOf(sp[1]);
        }
        int interval = Integer.valueOf(sc.nextLine());
        String ss = sc.nextLine();
        String[] ssp = ss.split(" ");
        int res = Integer.valueOf(ssp[0]) * 60 + Integer.valueOf(ssp[1]);

        Arrays.sort(a);

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] + interval <= res){
                System.out.println(a[i]/60 + " " + a[i]%60);
                return;
            }
        }
    }
}
