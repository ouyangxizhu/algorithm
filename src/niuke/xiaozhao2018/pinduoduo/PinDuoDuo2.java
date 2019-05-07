package niuke.xiaozhao2018.pinduoduo;

import java.util.Scanner;
/**
 * 题目描述
有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
输入描述:
空格分隔的两个字符串，代表输入的两个大整数
输出描述:
输入的乘积，用字符串表示
示例1
输入

复制
72106547548473106236 982161082972751393
输出

复制
70820244829634538040848656466105986748
 * @author ouyangxizhu
 *
 */
public class PinDuoDuo2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String num1 = scanner.next();
		String num2 = scanner.next();
		scanner.close();
		System.out.println(multiply(num1, num2));
	}

	public static String multiply(String num1, String num2) {
		num1 = new StringBuffer(num1).reverse().toString();
		num2 = new StringBuffer(num2).reverse().toString();
		int [] d = new int [num1.length() + num2.length()];
		for (int i = 0; i < num1.length(); i++) {
			int a = num1.charAt(i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int b = num2.charAt(j) - '0';
				d[i + j] += a*b;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < d.length; i++) {
			int digit = d[i] % 10;
			int carry = d[i] / 10;
			sb.insert(0, digit);
			if (i < d.length - 1) {
				d[i + 1] += carry;
			}
		}
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		
		return sb.length() == 0? "0" : sb.toString();
	}

}
