package niuke.xiaozhao2018.zhaoshangyinhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
按照卡中心校园招聘的要求，HR小招和小商需要从三个科室中（分别为A、B、C）抽派面试官去往不同城市。
两名HR按照以下规定轮流从任一科室选择面试官：每次至少选择一位，至多选择该科室剩余面试官数。最先选不到面试官的HR需要自己出差。
假设HR小招和小商都不想出差且每次选择都采取最优策略，如果是小招先选，写一个函数来判断她是否需要出差。如果不需要出差，请给出第一步的最优策略。
输入描述:
输入为三个正整数，分别代表三个科室的面试官人数，用英文逗号分隔
输出描述:
若小招需要出差，则输出：1；
若小招不需要出差，则输出：第一步选择的科室名称和选择人数，用英文逗号分隔
示例1
输入

复制
1,8,9
输出

复制
1
说明

示例2
输入

复制
2,0,4
输出

复制
C,2
说明


 * @author ouyangxizhu
 *
 */
public class ZhaoShangYinHang3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] s = str.split(",");
		int[] a = new int[s.length];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(s[i]);
			k ^=a[i];
		}
		if (k == 0) {
			System.out.println(1);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (highdigit(k) == highdigit(a[i])) {
				System.out.println((char)('A' + i) + "," + (a[i] - (a[i]^k)));
				break;
			}
			
		}
	}

	private static int highdigit(int k) {
		int count = 0;
		while (k != 0) {
			k = k >> 1;
			count ++;
		}
		return count;
	}
	

}
