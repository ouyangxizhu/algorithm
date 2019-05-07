package niuke.xiaozhao2018.zhaoshangyinhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
从非负整数序列 0, 1, 2, ..., n中给出包含其中n个数的子序列，请找出未出现在该子序列中的那个数。
输入描述:
输入为n+1个非负整数，用空格分开。
其中：首个数字为非负整数序列的最大值n，后面n个数字为子序列中包含的数字。
输出描述:
输出为1个数字，即未出现在子序列中的那个数。
示例1
输入

复制
3 3 0 1
输出

复制
2
说明


 * @author ouyangxizhu
 *
 */
public class ZhaoShangYinHang1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = n*(n + 1)/2;
		int allSum = 0;
		for (int i = 0; i < n; i++) {
			allSum += sc.nextInt();
		}
		sc.close();
		System.out.println(sum - allSum);
		
	}
	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < n; i++) {
			hashMap.put(sc.nextInt(), true);
		}
		for (int i = 0; i <= n; i++) {
			if (!hashMap.containsKey(i)) {
				System.out.println(i);
				return;
			}
		}
		
	}

}
