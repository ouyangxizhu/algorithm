package niuke.xiaozhao2017.meituan;

import java.util.Scanner;

/**
 * 题目描述
给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0-10000的非负整数）的不同组合的个数。
输入描述:
输入为一个数字N，即需要拼凑的面额
输出描述:
输出也是一个数字，为组成N的组合个数。
示例1
输入
复制
5
输出
复制
2
 * @author changzhen.zhang
 *
 */
public class MeiTuan3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if (n == 0) {
			System.out.println(0);
			return;
		}
		long [] dp = new long [n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		int [] a = {1, 5, 10, 20, 50, 100};
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j <= n ; j++) {
				if (j >= a[i]) {
					dp[j] +=  dp[j - a[i]];
				}
			}
		}
		System.out.println(dp[n]);
		
	}

}
