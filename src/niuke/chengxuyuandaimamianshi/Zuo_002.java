package niuke.chengxuyuandaimamianshi;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Zuo_002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int res = 1;

        for (int i = 0; i < n; i++) {
            if (res > n - i + 1) {
                System.out.println(res);
                return;
            }
            int max = a[i];
            int min = a[i];
            hashSet.add(a[i]);
            for (int j = i + 1; j < n; j++) {

                if (hashSet.contains(a[j]))
                    break;
                hashSet.add(a[j]);
                max = Math.max(max, a[j]);
                min = Math.min(min, a[j]);
                if (max - min == j - i) {
                    res = Math.max(res, max - min + 1);
                }
            }
            hashSet.clear();
        }
        System.out.println(res);


    }
}
