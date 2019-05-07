package bishi2019.zijietiaodong;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 * https://blog.csdn.net/XH413235699/article/details/88595458
 * 用stringbuffer更好
 * 
 * 简单模拟。去掉三连重复（aaa）的最后一个，两对（aabb）的最后一个，而且符合最后匹配，所以直接从左开始模拟，两个bool，
 * 一个表示当前位前1，2位是否相等，另一个表示当前位的前2，3位是否相同。
 * @author ouyangxizhu
 *
 */
public class ZiJieTiaoDong2 {
	public static int i = 0;
	public static int n = 0;

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (; i < n; i++) {
			String str = sc.next();
			check(str);
		}
        sc.close();
    }

	private static void check(String str) {
		boolean flag1 = false;
		boolean flag2 = false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (stack.isEmpty()) {
				stack.add(str.charAt(i));
			}else if (flag1) {
				if (flag2) {
					
					if (str.charAt(i) == stack.peek()) {
						continue;
					}else {
						stack.add(str.charAt(i));
						flag2 = false;
						flag1 = false;
					}
				}else {
					
					if (str.charAt(i) == stack.peek()) {
						continue;
					}else {
						stack.add(str.charAt(i));
						flag2 = true;
					}
				}
			}else {
				if (str.charAt(i) == stack.peek()) {
					stack.add(str.charAt(i));
					flag1 = true;
				}else {
					stack.add(str.charAt(i));
					flag1 = false;
				}
			}

		}
		ArrayList<Character> arrayList = new ArrayList<Character>(stack);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i));
		}
		if (i != n - 1) {
			System.out.println();
		}
	}

}
