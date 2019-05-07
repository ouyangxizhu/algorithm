package niuke.xiaozhao2017.haoweilai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * 题目描述
输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
输入描述:
每个测试输入包含2个整数,n和m
输出描述:
按每个组合的字典序排列输出,每行输出一种组合
示例1
输入
复制
5 5
输出
复制
1 4
2 3
5
 * @author changzhen.zhang
 *
 */
public class HaoWeLai6 {
	static List<String> lists = new ArrayList<>();
	static int m;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		printList("", 1, 0);
		for (String str : lists) {
			for (int i = 0; i < str.length() - 1; i++) {
				System.out.print(str.charAt(i));
				System.out.print(" ");
			}
			System.out.println(str.charAt(str.length() - 1));
		}
	}
	private static void printList(String str1, int index, int sum) {
		if (index > n + 1 || sum > m) {
			return;
		}else if (sum == m) {
			lists.add(str1);
			return;
		}else if (sum < m) {
			
			String str2 = str1;
			str2 = str1 + String.valueOf(index);
			printList(str2, index + 1, sum + index);
			printList(str1, index + 1, sum);
		}

	}

}
