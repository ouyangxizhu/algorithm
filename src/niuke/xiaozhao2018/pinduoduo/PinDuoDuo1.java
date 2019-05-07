package niuke.xiaozhao2018.pinduoduo;

import java.util.Scanner;

/**
 * 题目描述
给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
输入描述:
无序整数数组A[n]
输出描述:
满足条件的最大乘积
示例1
输入

复制
3 4 1 2
输出

复制
24
 * @author ouyangxizhu
 *
 */
public class PinDuoDuo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLong();
		}
		sc.close();
		System.out.println(getMax(arr));
	}

	private static long getMax(long[] arr) {
		long max1 = 0;
		long max2 = 0;
		long max3 = 0;
		long min1 = 0;
		long min2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (arr[i] > max1) {
					max3 = max2;
					max2 = max1;
					max1 = arr[i];
				}else if (arr[i] > max2) {
					max3 = max2;
					max2 = arr[i];
				}else if (arr[i] > max3) {
					max3 = arr[i];
				}else if (arr[i] < min1) {
					min2 = min1;
					min1 = arr[i];
				}else if (arr[i] > min1 && arr[i] < min2) {
					min2 = arr[i];
				}
				
			}
		}
		//最大数只能是最小的两个（负的）
		return Math.max(max1*max2*max3, max1*min2*min1);
	}

}
