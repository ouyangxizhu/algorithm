package qiuzhao2019.tencent1;

import java.util.Scanner;

public class Tencent1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int jishun = 0;
        int jishum = 0;
        int oushun = 0;
        int oushum = 0;

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if ((tmp & 1) == 1) {
                jishun++;
            } else {
                oushun++;
            }
        }
        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            if ((tmp & 1) == 1) {
                jishum++;
            } else {
                oushum++;
            }
        }

        System.out.println(Math.min(jishum, oushun) + Math.min(jishun, oushum));

    }



}
