package bishi2019.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/5.
 */
public class Tencent3 {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] p = new long[n];
        int[] m = new int[n];
        for (int i = 0; i < n; i ++){
            p[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i ++){
            m[i] = sc.nextInt();
        }
        if(n == 1){
            System.out.println(m[0]);
            return;
        }

        Long sum = 0L;
        int res = 0;
        cal(sum, res, p, m, 0);
        Collections.sort(list);
        System.out.println(list.get(0));

    }

    private static void cal(Long sum, int res, long[] p, int[] m, int index) {
        if (index >= p.length){
            list.add(res);
            return;
        }
        if (sum >=  p[index])
            cal(sum, res, p, m, index + 1);

        cal(sum + p[index], res + m[index], p, m, index + 1);

    }
}
