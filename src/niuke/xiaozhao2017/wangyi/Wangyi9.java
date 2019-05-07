package niuke.xiaozhao2017.wangyi;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.chrono.MinguoChronology;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 题目描述
你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。
为了让问题简单，我们用正整数表示不同颜色的颜料。
你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。
混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
输入描述:
第一行为绘制这幅画需要的颜色种数n (1 ≤ n ≤ 50)
第二行为n个数xi(1 ≤ xi ≤ 1,000,000,000)，表示需要的各种颜料.
输出描述:
输出最少需要在商店购买的颜料颜色种数，注意可能购买的颜色不一定会使用在画中，只是为了产生新的颜色。
示例1
输入
复制
3
1 7 3
输出
复制
3
 * @author changzhen.zhang
 *
 */
public class Wangyi9 {
	/**
	 * 作者：SEU…
链接：https://www.nowcoder.com/questionTerminal/5b1116081ee549f882970eca84b4785a
来源：牛客网

解释一下思路：这个题目就是，给一组数字，最少能由多少个数字异或出来。
异或有个性质 a^b=c 那么 a^c=b。
那对于这题，如果一个数字 x 的某一位为1（2进制），那我用这个数字和其他相同位为1的数字 i 分别进行异或运算作为 i 的值，
那么这组数里只剩 x 的这一位为 1，那么说明至少需要一个这个位上为1的数来异或出 x ，
再用相同的方法计算出除 x 外的数需要的颜料数就可以得到最后的结果。为了不计算重复的位值，将数组进行排序，
每次计算最高位（最大的数），下一个循环不计算这个数就OK。
而楼主的 if 语句是判断两个数的最高位是否都为1。
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int [n];
		int i = 0;
		for (i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			
		}
		for (i = n - 1; i >= 0; i--) {
			Arrays.sort(a);
			for (int j = i - 1; j >= 0; j--) {
				if ((a[i] ^ a[j]) < a[j]) {//满足这个条件的保证只能是首位都是相等的
					a[j] ^= a[i]; 
				}
			}
		}
		for (i = 0; a[i] == 0; i++);
		System.out.println(n - i);
		return;
	
	        
	}
	
}
