package bishi2019.liyejingdong;

import java.util.Scanner;
import java.util.Stack;

public class Jingdong_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        int[]  min = new int[n];
        int[] max = new int[n];
        min[n-1] = arr[n-1];
        for (int i = n-2; i >=0 ; i--) {
            min[i] = Math.min(min[i+1],arr[i]);
        }
        max[0] = arr[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i-1],arr[i]);
        }
        int aaa =1;


        for (int i = 1; i < n-1; i++) {
            if(max[i-1]<=min[i]) aaa++;
        }
        System.out.println(aaa);
    }
}
