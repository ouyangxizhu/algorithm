package niuke.xiaozhao2017.haoweilai;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 题目描述
读入一个字符串str，输出字符串str中的连续最长的数字串
输入描述:
个测试输入包含1个测试用例，一个字符串str，长度不超过255。
输出描述:
在一行内输出str中里连续最长的数字串。
示例1
输入
复制
abcd12345ed125ss123456789
输出
复制
123456789
 * @author changzhen.zhang
 *
 */
public class HaoWeLai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int end = 0;
		int max = 0;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				count ++;
				
				if (count > max) {
					max = count;
					end = i;
				}
			}else {
				count = 0;
			}
		}
		System.out.println(str.substring(end - max + 1, end + 1));
	}

}
