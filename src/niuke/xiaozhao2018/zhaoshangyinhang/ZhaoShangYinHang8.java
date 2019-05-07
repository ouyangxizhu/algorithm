package niuke.xiaozhao2018.zhaoshangyinhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
科室素拓进行游戏，游戏规则如下：随机抽取9个人作为游戏参与人员，分别编号1至9，每轮要求k(k<=9且k>=0)个人自由组合使编号之和为n。输出满足规则的所有可能的组合。要求组合内部编号升序输出，组合之间无顺序要求。
输入描述:
输入数据为以空格分隔的两个整数k和n
输出描述:
每行输出一个可能的编号组合，组合内部各个编号以空格分隔升序输出。若无满足规则的组合，则输出None
示例1
输入

复制
3 15
输出

复制
1 5 9
1 6 8
2 4 9
2 5 8
2 6 7
3 4 8
3 5 7
4 5 6
 * @author ouyangxizhu
 *
 */
public class ZhaoShangYinHang8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		if(n==0 || m==0 || k<=0 || k>n) {
            System.out.println(0);
            return;
       } 
		
	}	

}
