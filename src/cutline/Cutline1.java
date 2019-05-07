package cutline;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/0a50c0c8594048fdacf0ef523d8c112d
 * （切割绳子）有 n 条绳子，每条绳子的长度已知且均为正整数。绳子可以以任意正整数长度切割，但不可以连接。
 * 现在要从这些绳子中切割出 m 条长度相同的绳段，求绳段的最大长度是多少。
 * 
输入：第一行是一个不超过 100 的正整数 n，第二行是 n 个不超过 10^6 的正整数，表示每条绳子的长度，第三行是一个不超过 10^8 的正整数 m。
输出：绳段的最大长度，若无法切割，输出 Failed。
 * @author ouyangxizhu
 *
 */
public class Cutline1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt(); 
			count += arr[i];
		}
		if (count < m) {
			System.out.println("FAILED");
		}
		int left = 0;
		int right = Integer.MAX_VALUE;
		int mid = (left + right)/2;
		while (right - left > 0.5) {
			mid = (left + right)/2;
			if (checkvalid(arr, n, m, mid)) {
				left = mid;
			}else {
				right = mid;
			}
		}
		System.out.println(mid);
	}

	private static boolean checkvalid(int[] arr, int n, int m, int mid) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count += arr[i]/mid;
		}
		if (count >= m) {
			return true;
		}
		return false;
	}

	
}
