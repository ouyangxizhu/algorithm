package tencenttencent;

import java.util.Scanner;

public class First {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();//面额
            int m = in.nextInt();//价格
            System.out.println(maxCoinCount(n, m));
        }
    }

	private static int maxCoinCount(int n, int m) {
		int count = 0;
		int num = 0;
		for (int i = n; i > 0; i--) {
			num = m/i;
			count += num;
			m -= i * num; 
		}
		return count;
	}

}
