package niuke.xiaozhao2018.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,
 并且牛牛还希望这个三角形的周长越大越好。
 输入描述:
 输入包括一行,一行中有正整数a, b, c(1 ≤ a, b, c ≤ 100), 以空格分割
 输出描述:
 输出一个整数,表示能拼凑出的周长最大的三角形。
 示例1
 输入

 复制
 1 2 3
 输出

 复制
 5
 * @author ouyangxizhu
 *
 */
public class AiQiYi13 {
	/**
	 * 
	 * @param args
	 */

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];
		for (int i = 0; i < 3; i++){
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		while (a[2] >= a[1]){
			if (a[0] + a[1] > a[2] && a[2] - a[0] < a[1]){
				break;
			}
			a[2]--;
		}
		System.out.println(a[0] + a[1] + a[2]);


	}

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] lens = new int[3];
		for (int i=0; i!=3; i++) {
			lens[i] = sc.nextInt();
		}
		Arrays.sort(lens);
		if (lens[0] + lens[1] > lens[2]) {
			System.out.println(lens[0] + lens[1] + lens[2]);
		}
		else {
			System.out.println(2 * (lens[0] + lens[1]) - 1);
		}
	}

}
