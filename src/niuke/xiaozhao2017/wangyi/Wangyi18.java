package niuke.xiaozhao2017.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
小易邀请你玩一个数字游戏，小易给你一系列的整数。
你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如： 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，让你找出无法从n个数中选取部分求和的数字中的最小数（从1开始）。
输入描述:
输入第一行为数字个数n (n ≤ 20)
第二行为n个数xi (1 ≤ xi ≤ 100000)
输出描述:
输出最小不能由n个数选取求和组成的数
示例1
输入
复制
3
5 1 2
输出
复制
4
 * @author changzhen.zhang
 *
 */
public class Wangyi18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int miss = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] > miss + 1) {
				break;
			}
			else {
				miss += a[i];
			}
		}
		
	
		System.out.println(miss + 1);
		
	}
}
