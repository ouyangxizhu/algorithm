package niuke.xiaozhao2018.aiqiyi;

import java.util.Scanner;

/**
 * 
 * @author ouyangxizhu
 *
 */
public class AiQiYi6 {
	/**
	 *  
	 */


	/**
	 * 
	 * @param args
	 */

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		int sum = 0;
		for (int i = l; i <= r; i++){
			if (isHuiWen(i) && isSuShu(i)){
				sum++;
			}
		}
		System.out.println(sum);
        }

	private static boolean isSuShu(int n) {
		if (n == 1) return false;
		for (int i = 2; i <= n; i++){
			if (n % i == 0 && i!=n){
				return false;
			}
		}
		return true;
	}

	private static boolean isHuiWen(int m) {
		String s = String.valueOf(m);
		return new StringBuilder(s).reverse().toString().equals(s);
	}


}
