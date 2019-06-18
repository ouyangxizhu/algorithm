package zhaoshangyinhang;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int count = 0;
		int result = 0;
		Arrays.sort(arr);
		int [] high = new int [n - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			high[i] = arr[i + 1] - arr[i];
		}
		for (int i = high.length - 1; i >= 0; i--) {
			int m = high.length - i;
			count += high[i] * m;
			if (count > k) {
				result++;
				if (high[i] * m <= k) {
					count = high[i] * m;
				}
			}
		}
		if (count != 0) {
			
			System.out.println(++result);
		}else {
			System.out.println(result);
		}
		
		
	}

}
