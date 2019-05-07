package niuke.xiaozhao2017.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
输入描述:
输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
输出描述:
输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
示例1
输入
复制
20
输出
复制
3
 * @author changzhen.zhang
 *
 */
public class Wangyi27 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(count1(n));
	}

	private static int count(int n) {
		if ((n & 1) == 1 || n < 6 || n == 10) {
			return -1;
		}
		if (n % 8 == 0) {
			return n / 8;
		}
	
		return 1 + n / 8;
	}
	private static int count1(int n) {
		if ((n & 1) == 1) {
			return -1;
		}
		if (n == 6 || n ==8) {
			return 1;
		}else if (n < 10) {
			return -1;
		}
		int[] dp = new int[n + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[6] = 1;
		dp[8] = 1;
		for (int i = 6; i < dp.length; i++) {
			if (dp[i] != Integer.MAX_VALUE) {
				if (i + 6 < dp.length) {
					dp[i + 6] = Math.min(dp[i] + 1, dp[i + 6]);
				}
				if (i + 8 < dp.length) {
					dp[i + 8] = Math.min(dp[i] + 1, dp[i + 8]);
				}
			}
		}
		if (dp[n] == Integer.MAX_VALUE) {
			return -1;
		}else {
			return dp[n];
		}
	}
	
	

}
