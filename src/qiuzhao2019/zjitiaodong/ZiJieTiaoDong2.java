package qiuzhao2019.zjitiaodong;

import java.util.Scanner;

public class ZiJieTiaoDong2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split(" ");
        int n = Integer.valueOf(sp[0]);
        int k = Integer.valueOf(sp[1]);
        String sp1 = sc.nextLine();
        int[] putIn = new int[sp1.length()];
        for (int i = 0; i < sp1.length(); i++) {
            putIn[i] = sp1.charAt(i) - '0';
        }
        int[] res = new int[n];
        res[0] = putIn[0] ^ 0;
        int sum = res[0];
        for (int i = 1; i < n; i++) {
            res[i] = putIn[i] ^ (sum % 2);
            if(i < k - 1){
                sum += res[i];
            }else{
                sum = sum + res[i] - res[i - k + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i]);
        }
        System.out.println();
    }
}
