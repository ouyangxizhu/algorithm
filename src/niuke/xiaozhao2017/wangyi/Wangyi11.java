package niuke.xiaozhao2017.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  题目描述
二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。
每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
小易想知道最多可以放多少块蛋糕在网格盒子里。
输入描述:
每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
输出描述:
输出一个最多可以放的蛋糕数
示例1
输入
复制
3 2
输出
复制
4
 * @author changzhen.zhang
 *
 */
public class Wangyi11 {
	/**
	 *

	 * @param args
	 */
	static int[] a = new int [1001];
 	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		boolean [][] flag = new boolean[h][w];
		int res = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (flag[i][j] == false) {
					res++;
					if (i + 2 < h) {
						flag[i + 2][j] = true;
					}
					if (j + 2 < w) {
						flag[i][j + 2] = true;
					}
				}
			}
		}
		
		
		System.out.println(res);
	}
	
}
