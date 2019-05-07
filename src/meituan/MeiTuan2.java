package meituan;

import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/23.
 */
public class MeiTuan2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
            if(a[i] == 0){
                sum++;
            }
        }
        for (int i = 0; i < b.length; i++){
            b[i] = sc.nextInt();
        }
        System.out.println(sum);


    }
}
