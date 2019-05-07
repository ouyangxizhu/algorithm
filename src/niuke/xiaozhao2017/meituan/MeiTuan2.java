package niuke.xiaozhao2017.meituan;

import java.util.Scanner;

/**
 * 题目描述
有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
输入描述:
输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
输出描述:
输出包括一行，为走法的数目。
示例1
输入
复制
3 2
输出
复制
10
 * @author changzhen.zhang
 *
 */
public class MeiTuan2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(multply(n + m, m));
		sc.close();
	}

	private static int multply(int n, int m) {
		long result1 = 1;
		long result2 = 1;
		int nn = n;
		int mm = m;
		for (int i = 0; i < m; i++) {
			result1 *= nn;
			nn = nn - 1;
			result2 *= mm;
			mm = mm - 1;
		}
		
		return (int) (result1/result2);
	}
	/**
	 * 动态规划
	 */
	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [][] dp = new int [n + 1][m + 1];
		sc.close();
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; 
			}
		}
		System.out.println(dp[n][m]); 
	
	}

}
