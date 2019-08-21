package niuke.chengxuyuandaimamianshi;

import niuke.xiaozhao2017.souhu.Souhu1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Zuo_004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int k = sc.nextInt();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int left = 0;
        int right = n - 1;
        while (left < right){
            int i = left + 1;
            int j = n - 1;
            int target = k - a[left];
            while (i < j) {
                if (a[i] + a[j] == target) {
                    System.out.println(a[left] + " " + a[i] + " " + a[j]);

                    while (i < j && a[i + 1] == a[i]) {
                        i++;
                    }
                    while (i < j && a[j - 1] == a[j]) {
                        j--;
                    }
                    i++;
                    j--;

                } else if (a[i] + a[j] < target) {
                    i ++;
                }else
                    j--;

            }

            while (left < n - 1 && a[left + 1] == a[left]) {
                left++;
            }
            left++;

        }
    }
}
