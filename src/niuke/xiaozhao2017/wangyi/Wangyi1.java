package niuke.xiaozhao2017.wangyi;

import java.util.Scanner;

/**
 * 题目描述
有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
输入描述:
每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
输出描述:
输出一行表示最大的乘积。
示例1
输入
复制
3
7 4 7
2 50
输出
复制
49
 * @author changzhen.zhang
 *
 */
public class Wangyi1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		int K = sc.nextInt();
		int d = sc.nextInt();
		//dpMax[k][n]表示，选k个学生，以第n个学生为结尾的最大乘积
		long [][] dpMax = new long[K + 1][n + 1];
		//dpMin[k][n]表示，选k个学生，以第n个学生为结尾的最小乘积，因为有负数
		long [][] dpMin = new long[K + 1][n + 1];
		long res = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {//从第几个开始
			dpMax[1][i] = a[i];
			dpMin[1][i] = a[i];
			
//			for (int k = 2; k <= K; k++) {
//				for (int j = i - 1; j > 0 && i - j <= d; j--) {
//					dpMax[k][i] = Math.max(dpMax[k][i], Math.max(dpMax[k - 1][j] * a[i], dpMin[k - 1][j] * a[i]));
//					dpMin[k][i] = Math.min(dpMin[k][i], Math.min(dpMax[k - 1][j] * a[i], dpMin[k - 1][j] * a[i]));
//				}
//			}
			for (int j = i - 1; j > 0 && i - j <= d; j--) {
				for (int k = 2; k <= K; k++) {
					dpMax[k][i] = Math.max(dpMax[k][i], Math.max(dpMax[k - 1][j] * a[i], dpMin[k - 1][j] * a[i]));
					dpMin[k][i] = Math.min(dpMin[k][i], Math.min(dpMax[k - 1][j] * a[i], dpMin[k - 1][j] * a[i]));
				}
			}
			res = Math.max(res, dpMax[K][i]);
		}
		System.out.println(res);
		
	}
	

}
