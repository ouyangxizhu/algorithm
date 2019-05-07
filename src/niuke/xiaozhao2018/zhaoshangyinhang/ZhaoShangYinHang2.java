package niuke.xiaozhao2018.zhaoshangyinhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
小招喵喜欢在数轴上跑来跑去，假设它现在站在点n处，它只会3种走法，分别是：
1.数轴上向前走一步，即n=n+1 
2.数轴上向后走一步,即n=n-1 
3.数轴上使劲跳跃到当前点的两倍，即n=2*n
现在小招喵在原点，即n=0，它想去点x处，快帮小招喵算算最快的走法需要多少步？
输入描述:
小招喵想去的位置x
输出描述:
小招喵最少需要的步数
示例1
输入

复制
3
输出

复制
3

 * @author ouyangxizhu
 *
 */
public class ZhaoShangYinHang2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n < 0) {
			n = -n;
		}
		if (n <= 2) {
			System.out.println(n);
			return;
		}
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < dp.length; i++) {
			if ((i & 1) == 1) {
				dp[i] = 1 + Math.min(dp[i - 1], dp[(i + 1)/2] + 1);  
			}else {
				dp[i] = 1 + Math.min(dp[i - 1], dp[i/2]); 
			}
		}
		System.out.println(dp[n]);
		
		
	}
	

}
