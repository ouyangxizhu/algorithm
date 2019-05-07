package bishi2019.zijietiaodong;

import java.util.Scanner;
/**
 * https://blog.csdn.net/XH413235699/article/details/88595458
 * 找钱问题，共1024，64，16，4，1几种面值。因为1，4，16，64这几种面值都可以由小于他们的面值凑出来，所以直接贪心的选最大的面值就好。
 * @author ouyangxizhu
 *
 */
public class ZiJieTiaoDong1 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 1024 - sc.nextInt();
        sc.close();
        int[] a = {1, 4, 16, 64};
        int count = 0;
        if (n == 1024) {
			System.out.println(0);
			return;
		}
        for (int i = a.length - 1; i >= 0 ; i--) {
			if(n >= a[i]){
				count += n/a[i];
				n %= a[i];
			}else {
				continue;
			}
		}
        System.out.println(count);
    }

}
