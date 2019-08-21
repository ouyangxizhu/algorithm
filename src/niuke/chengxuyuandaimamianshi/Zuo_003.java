package niuke.chengxuyuandaimamianshi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Zuo_003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int left = 0;
        int right = n - 1;
        while (left < right){
            if (a[left] + a[right] == k) {
                System.out.println(a[left] + " " + a[right]);

                while (a[left + 1] == a[left]) {
                    left++;
                }
                while (a[right - 1] == a[right]) {
                    right--;
                }
                left++;
                right--;

            } else if (a[left] + a[right] < k) {
                left ++;
            }else
                right--;
        }
    }
}
