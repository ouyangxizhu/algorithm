package niuke.xiaozhao2018.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 牛牛有4根木棍,长度分别为a,b,c,d。羊羊家提供改变木棍长度的服务,如果牛牛支付一个硬币就可以让一根木棍的长度加一或者减一。
 牛牛需要用这四根木棍拼凑一个正方形出来,牛牛最少需要支付多少硬币才能让这四根木棍拼凑出正方形。
 输入描述:
 输入包括一行,四个整数a,b,c,d(1 ≤ a,b,c,d ≤ 10^6), 以空格分割
 输出描述:
 输出一个整数,表示牛牛最少需要支付的硬币
 示例1
 输入

 复制
 4 1 5 4
 输出

 复制
 4
 * @author ouyangxizhu
 *
 */
public class AiQiYi9 {
	/**
	 * 
	 * @param args
	 */

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int[] a = new int[4];
		for (int i = 0; i < 4; i++){
			a[i] = sc.nextInt();
		}
		int res = 0;
		Arrays.sort(a);
		for (int i = 0; i < 4; i++){
			res += Math.abs(a[i] - a[2]);
		}

		System.out.println(res);


	}

}
