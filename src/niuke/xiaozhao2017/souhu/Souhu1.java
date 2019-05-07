package niuke.xiaozhao2017.souhu;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
输入描述:
输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 50000。第二行是希望去掉的数字数量cnt 1 ≤ cnt < length(number)。
输出描述:
输出保留下来的结果。
示例1
输入
复制
325 1
输出
复制
35
 * @author changzhen.zhang
 *
 */
public class Souhu1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int count = Integer.valueOf(sc.next());
		if (count >= str.length()) {
			System.out.println();
			return;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			while (!stack.isEmpty() && count > 0) {
				if (str.charAt(i) > stack.peek()) {
					stack.pop();
					count--;
				}else {
					break;
				}
			}
			stack.push(str.charAt(i));
		}
		while (count > 0) {
			stack.pop();
			count --;
		}
		Object[] a = stack.toArray();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}

}
