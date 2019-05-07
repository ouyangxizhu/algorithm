package niuke.xiaozhao2018.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 题目描述
六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，
对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。
老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
输入描述:
第一行：n，表示h数组元素个数
 第二行：n个h数组元素
 第三行：m，表示w数组元素个数
 第四行：m个w数组元素
输出描述:
上台表演学生人数
示例1
输入

复制
3 
 2 2 3
 2
 3 1 
输出

复制
1
 * @author ouyangxizhu
 *
 */
public class PinDuoDuo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// the number of student
		int[] h = new int[n];
		for (int i = 0; i < h.length; i++) {
			h[i] = sc.nextInt();
		}
		int m = sc.nextInt();// the number of candy
		int[] w = new int[m];
		for (int j = 0; j < w.length; j++) {
			w[j] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(h);
		Arrays.sort(w);
		System.out.println(count(h, w));
	}

	private static int count(int[] h, int[] w) {
		int result = 0;
		int staStudent = 0;
		for (int i = 0; i < w.length; i++) {
			if (w[i] >= h[staStudent]) {
				result ++;
				staStudent ++;
				if (staStudent == h.length) {
					break;
				}
			}
			
		}
		return result;
	}

}
