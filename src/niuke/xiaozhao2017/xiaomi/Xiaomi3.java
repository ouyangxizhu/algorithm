package niuke.xiaozhao2017.xiaomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目描述
现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
输入描述:
输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
输出描述:
输出树的高度，为一个整数
示例1
输入
复制
5
0 1
0 2
1 3
1 4
输出
复制
3
 * @author changzhen.zhang
 *
 */
public class Xiaomi3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//key表示节点，value表示该节点的深度
		HashMap<Integer, Integer> deep = new HashMap<Integer, Integer>();
		//key表示节点，value表示该节点的孩子个数
		HashMap<Integer, Integer> numChild = new HashMap<Integer, Integer>();
		deep.put(0, 1);//默认是一
		numChild.put(0, 0);
		int max = 1;
		for (int i = 0; i < n - 1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			if (!deep.containsKey(parent) || numChild.get(parent) >= 2) {
				continue;
			}
			
			deep.put(child, deep.get(parent) + 1);
			numChild.put(parent, numChild.get(parent) + 1);
			numChild.put(child, 0);
			max = Math.max(max, deep.get(child));
		}
		System.out.println(max);
		
	}

}
