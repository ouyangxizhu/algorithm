package niuke.xiaozhao2018.aiqiyi;

import java.util.Scanner;
/**
 * 题目描述
对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,
例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
输入描述:
输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割
输出描述:
如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
示例1
输入

复制
1010 3 101010 2
输出

复制
Equal
 * @author ouyangxizhu
 *
 */
public class AiQiYi1 {

	public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int x1 = sc.nextInt();
	        int k1 = sc.nextInt();
	        int x2 = sc.nextInt();
	        int k2 = sc.nextInt();
	        compare(x1, k1, x2, k2);
	        sc.close();
	    }

	private static void compare(int x1, int k1, int x2, int k2) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while (k1-- > 0) {
			sb1.append(x1 + "");
		}
		while (k2-- > 0) {
			sb2.append(x2 + "");
		}
		int l1 = sb1.length();
		int l2 = sb2.length();
		if (l1 > l2) {
			System.out.println("Less");
			return;
		}else if (l1 < l2) {
			System.out.println("Greater");
			return;
		}
		for (int i = 0; i < l1; i++) {
			if (sb1.charAt(i) > sb2.charAt(i)) {
				System.out.println("Greater");
				return;

			}else if (sb1.charAt(i) < sb2.charAt(i)) {
				System.out.println("Less");
				return;
			}
		}
		System.out.println("Equal");
	}

}
