package tencenttencent;

import java.util.Scanner;

public class Three {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
           arr[i] = sc.nextInt();
        }
       
        if (n < s) {
			System.out.println(0);
			return;
		}else if(n == s) {
			System.out.println(1);
			return;
		}else {
			
			System.out.println(count(n, s));
		}
    }

	public static int count(int n,int s) {
		
		return 2 * multiply(n, s)/multiply(s);
	}

	private static int multiply(int s) {
		int result = 1;
		for (int i = 1; i <= s; i++) {
			result *= i;
		}
		return result;
	}

	private static int multiply(int n, int i) {
		int result = 1;
		for (int j = n; j > n - i; j--) {
			result *= j;
		}
		return result;
	}

}
