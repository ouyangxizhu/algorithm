package niuke.xiaozhao2017.wangyi;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * 题目描述
小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
输入描述:
输入一个初始位置x_0,范围在1到1,000,000,006
输出描述:
输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
示例1
输入
复制
125000000
输出
复制
1
 * @author changzhen.zhang
 *
 */
public class Wangyi14 {
	/**
	 * 
速度不快但是思路简单。

4x + 3等于做了两次2x + 1， 8x + 7做了三次。

从起点开始令x0 = 2*x0 + 1，统计做了多少次2x + 1后模1000000007等于0

再把次数分解成若干个3与2的和，3的个数加上2的个数最小，不超过100000
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count = 0;
		while (a != 0 && count <= 300000) {
			a = ((a<<1) + 1)%1000000007;
			count++;
		}
		int res = (count+2)/3;
		System.out.println(res > 100000 ? -1 : res);
	}

}
