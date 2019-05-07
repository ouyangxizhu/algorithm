package niuke.xiaozhao2017.tencent;

import java.util.Scanner;

/**
 *题目描述
给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
输入描述:
输入包括一个整数n,(3 ≤ n < 1000)
输出描述:
输出对数
示例1
输入
复制
10
输出
复制
2
 * @author changzhen.zhang
 *
 */
public class Tencent3 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int count = 0;
		for (int i = 2; i <= n/2 ; i++) {
			if (isss(i) && isss(n - i)) {
				count ++;
			}
		}
		System.out.println(count);
	   
	}
	public static boolean isss(int m) {
		for (int j = 2; j <= Math.sqrt(m); j++) {
			if (m % j == 0) {
				return false;
			}
		}
		return true;
	}

}
