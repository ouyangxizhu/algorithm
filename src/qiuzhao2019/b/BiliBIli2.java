package qiuzhao2019.b;

import niuke.xiaozhao2017.souhu.Souhu1;

import java.util.Scanner;

public class BiliBIli2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N <= 0) {
            System.out.println(0);
            return;
        }
        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }
        int num = 1;
        int end = (N + 1)>>1;
        while ((1 + end)*end /2 >= N){
            int sum = 0;
            for (int i = end; i > 0; i--) {
                sum += i;
                if (sum == N) {
                    num++;
                    break;
                } else if (sum > N) {
                    break;
                }
            }
            end--;
        }
        System.out.println(num);
    }
}
