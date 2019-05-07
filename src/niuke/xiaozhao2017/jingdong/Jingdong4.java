package niuke.xiaozhao2017.jingdong;

import java.util.Scanner;

/**
 * 题目描述
小明同学学习了不同的进制之后，拿起了一些数字做起了游戏。
小明同学知道，在日常生活中我们最常用的是十进制数，而在计算机中，二进制数也很常用。
现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)。 
f(x)表示把x这个数用十进制写出后各个数位上的数字之和。如f(123)=1+2+3=6。 
g(x)表示把x这个数用二进制写出后各个数位上的数字之和。如123的二进制表示为1111011，
那么，g(123)=1+1+1+1+0+1+1=6。 
小明同学发现对于一些正整数x满足f(x)=g(x)，
他把这种数称为幸运数，现在他想知道，大于0且小于等于n的幸运数有多少个？
输入描述:
每组数据输入一个数n(n<=100000)
输出描述:
每组数据输出一行，小于等于n的幸运数个数。
示例1
输入
复制
21
输出
复制
3
 * @author changzhen.zhang
 *
 */
public class Jingdong4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result = 0;
		for (int i = 1; i <= num; i++) {
			if (hexsum(i, 10) == hexsum(i, 2)) {
				result ++;
			}
		}
		System.out.println(result);
	
		sc.close();
	}

	
	private static int hexsum(int m, int n) {
		int sum = 0;
		while (m != 0) {
			sum += m % n;
			m = m / n;
		}
		return sum;
	}

}
