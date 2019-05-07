package bishi2019.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Wangyi20 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 3){
            System.out.println(n/3);
            return;
        }
        int [] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        sc.close();
        int sum = 0;
        for (int i = 0; i < a.length - 2; i ++){
            for (int j = i + 1; j < a.length - 1;j++){
                if (isTrue(i, j)){
                    sum += a.length - j - 1;
                }else{
                    for (int k = j + 1;k < a.length;k ++)
                        if (isTrue(a[i], a[j], a[k])){
                            sum++;
                        }
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean isTrue(int a, int b) {
        if (a == 1 || b - a == 1){
            return true;
        }
        if (a == b){
            return false;
        }
        for (int i = gcd(a, b); i > 1; i--){
            if (a % i == 0 && b % i == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean isTrue(int a, int b, int c) {
        if (a == 1){
            return true;
        }
        for (int i = gcd(a, b); i > 1; i--){
            if (a % i == 0 && b % i == 0 || c % i == 0){
                return false;
            }
        }
        return true;
    }
    private static int gcd(int a, int b) {
        while(true){
            if ((a = a % b ) == 0)
                return b;
            if ((b = b % a) == 0)
                return a;
        }
    }
}
