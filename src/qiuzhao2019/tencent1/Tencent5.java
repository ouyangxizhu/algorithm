package qiuzhao2019.tencent1;

import java.util.Calendar;
import java.util.Scanner;

public class Tencent5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int res = 0;
            for (int j = left; j <= right; j++) {
                if (j < k) {
                    res++;
                } else if (j == k) {
                    res += 2;
                } else {
                    for (int l = 0; l * k <= j; l++) {
                        if (l == 0 || l * k == j) {
                            res += 1;
                        } else {
                            if (l < j - l * k + 1) {
                                res += cal(l, j - l * k + 1);
                            } else if (l == j - l * k + 1) {
                                res += 2;
                            } else {
                                res += cal(j - l * k + 1, l + 1);
                            }
                        }

                    }
                }
            }
            System.out.println(res);
        }

    }
    public static int cal(int n, int m) {
        int fenzi = m;
        int fenmu = n;
        int count = n - 1;
        while (count!= 0) {
            fenzi *= m - count;
            fenmu *= n - count;
            count--;
        }
        return fenzi/fenmu;

    }
}
