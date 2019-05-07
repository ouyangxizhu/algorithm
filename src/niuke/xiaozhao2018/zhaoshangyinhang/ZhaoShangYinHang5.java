package niuke.xiaozhao2018.zhaoshangyinhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
小明在卡中心工作，用到的很多系统账号都需要设置安全密码。密码如果符合以下规范可以称为安全密码：
1、密码至少包含6个字符，至多包含20个字符；
2、至少包含一个小写字母，至少包含一个大写字母，至少包含一个数字；
3、不能出现连续3个相同的字母。

请写一个检查密码是否为安全密码的函数。
输入为一个字符串作为密码，输出为将该密码改为安全密码的最小改变次数。如果它已经是安全密码，则返回0。
备注：插入、删除、或者替换一个字符，均视为改变一次。
输入描述:
输入为一个字符串作为密码。
输出描述:
输出为将该密码改为安全密码的最小改变次数。如果它已经是安全密码，则返回0。
示例1
输入

复制
aB3ab3
输出

复制
0
说明

示例2
输入

复制
aaaaaa
输出

复制
2
说明

示例3
输入

复制
abcdefG
输出

复制
1
 * @author ouyangxizhu
 *
 */
public class ZhaoShangYinHang5 {

	static int count = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		char[] c = str.toCharArray();
		int n = distinct(c);
		System.out.println(n);
	}

	public static int distinct(char[] c) {
		int x = distinct2(c);
		int y = distinct3(c);
		if (c.length < 6) {
			int p = 6 - c.length;
			if (x <= y) {
				count = p + y;
			} else {
				count = p + x;
			}
		}
		if (c.length >= 6 && c.length <= 20) {
			if (x <= y) {
				count = y;
			} else {
				count = x;
			}
		}
		if (c.length > 20) {
			int q = c.length - 20;
			char[] ch = new char[20];
			for (int i = 0; i < ch.length; i++) {
				ch[i] = c[i];
			}

			x = distinct2(ch);
			// y = distinct3("6$$$$$$$$$$54321####".toCharArray());
			y = distinct3(ch);
			if (x <= y) {
				count = q + y;
			} else {
				count = q + x;
			}
		}
		return count;
	}

	public static int distinct2(char[] c) {
		int a = 0;
		int[] h = { 0, 0, 0 };
		for (char d : c) {
			if (d >= 'a' && d <= 'z') {
				h[0]++;
			} else if (d >= 'A' && d <= 'Z') {
				h[1]++;
			} else {
				h[2]++;
			}
		}
		for (int i : h) {
			if (i == 0) {
				a++;
			}
		}

		return a;
	}

	public static int distinct3(char[] c) {
		int b = 0;
		int d = 0;
		int m = 1;
		for (int i = 0; i < c.length; i++) {
			if (i - 1 >= 0 && c[i] == c[i - 1]) {
				m++;
				if (m >= 3) {
					b = m / 3;
				}
			} else {
				d += b;
				m = 1;
				b = 0;
			}
		}
		if (m >= 3) {
			d = m / 3 + d;
		}
		return d;
	}
}
