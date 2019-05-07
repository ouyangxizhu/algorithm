package niuke.xiaozhao2017.haoweilai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * 题目描述
将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
输入描述:
每个测试输入包含1个测试用例： I like beijing. 输入用例长度不超过100
输出描述:
依次输出倒置之后的字符串,以空格分割
示例1
输入
复制
I like beijing.
输出
复制
beijing. like I
 * @author changzhen.zhang
 *
 */
public class HaoWeLai4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] split = str.split(" ");
		for (int i = split.length - 1; i > 0 ; i--) {
			System.out.print(split[i] + " ");
		}
		System.out.println(split[0]);
	}

}
