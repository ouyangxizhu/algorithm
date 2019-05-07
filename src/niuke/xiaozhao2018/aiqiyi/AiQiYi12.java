package niuke.xiaozhao2018.aiqiyi;

import java.util.Scanner;

/**
 * 题目描述
 牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
 牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。
 牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。牛牛想知道他最少需要涂染几个正方形。
 如样例所示: s = RGRGR
 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
 输入描述:
 输入包括一个字符串s,字符串s长度length(1 ≤ length ≤ 50),其中只包括'R'或者'G',分别表示红色和绿色。
 输出描述:
 输出一个整数,表示牛牛最少需要涂染的正方形数量
 示例1
 输入

 复制
 RGRGR
 输出

 复制
 2
 * @author ouyangxizhu
 *
 */
public class AiQiYi12 {

	/**
	 *
	 我觉得我的方法简单,看大家很多是遍历所有可能的分界点做的,说一下我的方法,只需要遍历一次数组,
	 在当前位置为R时有可能两种情况,一种是吧这个位置编程G,另一种是吧前面的G全部变成R.

	 时间复杂度O(n),空间复杂度O(1)
	 * @param args
	 */

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
		int res = 0;
		int gCount = 0;
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i) == 'G'){
				gCount++;
			} else{
				res = Math.min(gCount, res + 1);
			}

		}
		System.out.println(res);

	}

}
