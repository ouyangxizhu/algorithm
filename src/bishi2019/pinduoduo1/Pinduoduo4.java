package bishi2019.pinduoduo1;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 一座城市有若干栋高楼，为举行一项特殊的定高跳级活动需要n栋楼高度相同。
 * 市长有权利对任何高楼增加若干层，求一共最少需要增加多少层楼才能满足举办活动的条件
 *
 * 输入包括两行
 *
 * 第一行 包括两个数，
 * 第一个数字为高楼的数量m，
 * 第二个数字为活动需要的N栋楼，（1 <=n <= m <= 4000）
 *
 * 第二行包括m个数字，分别表示这些高楼的高度（1 <=h<=4000）
 *
 *
 * 输出
 * 输出一行包括一个数字，表示为了举办这次活动最少需要增高的总层数
 *
 * 输入
 *  5 3
 *  1 1 2 3 3
 *
 *  输出
 *  1
 *
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo4 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] flags = new int[n];
        Arrays.fill(flags, -1);

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = n - 1; i >= m - 1; i--){
            int sum = 0;
            for (int j = 1; j < m; j ++ ){
                sum += (arr[i] - arr[i - j]);
            }
            flags[i] = sum;

        }
        int max = Integer.MAX_VALUE;
        for(int i = m - 1; i < n; i++){
            max = Math.min(max,flags[i]);
        }

        System.out.println(max);
    }
}
