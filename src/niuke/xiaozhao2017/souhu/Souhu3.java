package niuke.xiaozhao2017.souhu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，
每隔一米就有一个，每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。
每个弹簧力量不同，用一个数字代表它的力量，
如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。
河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，
给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
输入描述:
输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
输出描述:
输出最少的跳数，无法到达输出-1
示例1
输入
复制
5
2 0 1 1 1
输出
复制
4
 * @author changzhen.zhang
 *
 */
public class Souhu3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 10000);
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] == 0) {
					continue;
				}
				if (arr[j] + j >= i) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		if (dp[n] >= 10000) {
			System.out.println(-1);
		}else {
			System.out.println(dp[n]);
		}
		
	}

}
