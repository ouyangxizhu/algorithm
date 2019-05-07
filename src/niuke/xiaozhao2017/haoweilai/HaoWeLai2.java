package niuke.xiaozhao2017.haoweilai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 题目描述
找出n个数里最小的k个
输入描述:
每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
不超过100。
输出描述:
输出n个整数里最小的k个数。升序输出
示例1
输入
复制
3 9 6 8 -10 7 -11 19 30 12 23 5
输出
复制
-11 -10 3 6 7
 * @author changzhen.zhang
 *
 */
public class HaoWeLai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (sc.hasNextInt()) {
			list.add(sc.nextInt());
			
		}
		int m = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		Collections.sort(list);
		for (int i = 0; i < m; i++) {
			if (i != m - 1) {
				System.out.print(String.valueOf(list.get(i)) + " ");
				continue;
			}
			System.out.println(String.valueOf(list.get(i)));
		}
	}

}
