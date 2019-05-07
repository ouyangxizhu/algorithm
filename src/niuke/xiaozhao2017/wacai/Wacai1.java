package niuke.xiaozhao2017.wacai;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
输入描述:
输入数据有多组，每组占一行，由两个整数n（n < 10000）和m(m < 1000)组成，n和m的含义如前所述。
输出描述:
对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
示例1
输入
复制
81 4
2 2
输出
复制
94.73
3.41
 * @author changzhen.zhang
 *
 */
public class Wacai1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		double[] a = new double[m];
		a[0] = n;
		double sum = n;
		if (m <= 0) {
			System.out.println(0);
			return;
		}
		if (m == 1) {
			System.out.println(n);
			return;
		}
			
		for (int i = 1; i < m; i++) {
			a[i] = Math.sqrt(a[i - 1]);
			sum += a[i];
		}
		System.out.println(String.format("%.2f", sum));
	}

}
