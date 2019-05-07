package bishi2019.pinduoduo1;


import java.util.Scanner;

/**
 * a国有k种不同的方言，通过调查得知
 * 有X1人说第1种方言
 * 有X2人说第2种方言
 * 。。。。
 * 有Xk人说第k种方言
 * 已知a国共有n人，问会说所有k种方言的人至少有多少
 *
 * 输入
 * 第一行包括两个数n,k分别表示a国人口数量和方言数量。
 * 第二行包括k个整数，其中第i个数表示会说第i种方言的人数
 *
 * 数据范围
 * 2 <= k <=20
 * 1 <=xi <= N <= 1000000000
 *
 * 输出一行
 * 一个整数  会说所有方言的最少人数
 *
 * 输入
 * 1000000000 2
 * 800000000 800000000
 *
 * 输出
 * 600000000
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo2 {
    /**
     *
     * @param args
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = n;
        for (int i = 0; i < k; i++){
            int tmp = sc.nextInt();
            tmp = n - tmp;
            res = res - tmp;

        }
        if (res < 0)
            res = 0;
       System.out.println(res);

    }
}
