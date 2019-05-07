package niuke.xiaozhao2017.xiaomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 题目描述
给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao mi”-> “mi xiao hello”
输入描述:
输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
输出描述:
对于每个测试示例，要求输出句子中单词反转后形成的句子
示例1
输入
复制
hello xiao mi
输出
复制
mi xiao hello
 * @author changzhen.zhang
 *
 */
public class Xiaomi2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String string = (String) sc.nextLine();
			String[] split = string.split(" ");
			for (int i = split.length - 1; i > 0; i--) {
				System.out.print(split[i] + " ");
			}
			System.out.print(split[0]);
		}
		
	}

}
