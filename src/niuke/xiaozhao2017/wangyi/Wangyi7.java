package niuke.xiaozhao2017.wangyi;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.chrono.MinguoChronology;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 题目描述
牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t，根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。注意，子序列不要求在原字符串中是连续的，例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
输入描述:
每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见 ASCII 字符串。
输出描述:
输出一行 “Yes” 或者 “No” 表示结果。
示例1
输入
复制
x.nowcoder.com
ooo
输出
复制
Yes
 * @author changzhen.zhang
 *
 */
public class Wangyi7 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s2.length(); i++) {
			sb.append(".*").append(s2.charAt(i));
		}
		if (s1.matches(sb.append(".*").toString())) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	        
	}
	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i++) == s2.charAt(j)) {
				j++;
			}
			
		}
		if (j == s2.length()) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
