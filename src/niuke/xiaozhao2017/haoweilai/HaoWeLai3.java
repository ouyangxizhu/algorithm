package niuke.xiaozhao2017.haoweilai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 题目描述
输入n个整数，输出出现次数大于等于数组长度一半的数。
输入描述:
每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
输出描述:
输出出现次数大于等于n/2的数。
示例1
输入
复制
3 9 3 2 5 6 7 3 2 3 3 3
输出
复制
3
 * @author changzhen.zhang
 *
 */
public class HaoWeLai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int res = Integer.MIN_VALUE;
		while (sc.hasNextInt()) {
			int a = sc.nextInt();
			if (a != res) {
				if (count > 0) {
					count--;
				}else {
					count = 1;
					res = a;
				}
			}else {
				count ++;
			}
			
		}
		System.out.println(res);
	}

}
