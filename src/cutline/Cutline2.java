package cutline;

import java.util.Scanner;

/**
 * （剪绳子问题。一根绳子可以任意裁剪，但是不能拼接。一共n根，要搞出来m条相等的绳子，且长度最长，结果保留两位小数。
 * 二分答案求最大值。复杂度O(nlog2^31)。
 * @author ouyangxizhu
 *
 */
public class Cutline2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		double[] arr = new double[n];
		double left = 0;
		double right = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt(); 
		}
		while (right - left > 0.001) {
			double mid = (left + right)/2;
			if (checkvalid(arr, n, m, mid)) {
				left = mid;
			}else {
				right = mid;
			}
		}
		System.out.println(String.format("%.2f", left));
	}

	private static boolean checkvalid(double[] arr, int n, int m, double mid) {
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
