package niuke.xiaozhao2017.didi;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 题目描述
给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
输入描述:
输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
输出描述:
为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
示例1
输入
复制
7 2
输出
复制
111
 * @author changzhen.zhang
 *
 */
public class DiDi5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean flag = false;
		if (m < 0) {
			m = - m;
			flag = true;
		}
		StringBuilder sb = new StringBuilder();
		while (m != 0) {
			sb.append(digit(m, n));
			m = m/n;
		}
		String string = sb.reverse().toString();
		if (flag) {
			
			System.out.println("-" + string);
		}else {
			
			System.out.println(string);
		}
		
	}

	private static String digit(int m, int n) {
		String[] numToStr = {"A", "B", "C","D", "E", "F"};
		if (m % n < 10) {
			return String.valueOf(m % n);
		}else {
			return numToStr[m % n - 10];
		}
	}
	
}
