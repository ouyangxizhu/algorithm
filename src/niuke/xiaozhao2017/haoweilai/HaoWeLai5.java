package niuke.xiaozhao2017.haoweilai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * 题目描述
输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
输入描述:
每个测试输入包含2个字符串
输出描述:
输出删除后的字符串
示例1
输入
复制
They are students. aeiou
输出
复制
Thy r stdnts.
 * @author changzhen.zhang
 *
 */
public class HaoWeLai5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String pattern = "[" + str2 + "]";
		String replaceAll = str1.replaceAll(pattern, "");
		System.out.println(replaceAll);
	}

}
