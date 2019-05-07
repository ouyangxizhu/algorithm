package niuke.xiaozhao2018.aiqiyi;

import java.util.Scanner;
/**
 * 题目描述
牛牛参加了一场考试,考试包括n道判断题,每做对一道题获得1分,牛牛考试前完全没有准备,所以考试只能看缘分了,
牛牛在考试中一共猜测了t道题目的答案是"正确",其他的牛牛猜为"错误"。考试结束后牛牛知道实际上n道题中有a个题目的答案应该是"正确",
但是牛牛不知道具体是哪些题目,牛牛希望你能帮助他计算可能获得的最高的考试分数是多少。
输入描述:
输入包括一行,一行中有三个正整数n, t, a(1 ≤ n, t, a ≤ 50), 以空格分割
输出描述:
输出一个整数,表示牛牛可能获得的最高分是多少。
示例1
输入

复制
3 1 2
输出

复制
2
 * @author ouyangxizhu
 *
 */
public class AiQiYi3 {
	/**
	 * 
	 * @param args
	 */

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        sc.close();
        if (a > t) {
			System.out.println(t + n - a);
		}else {
			System.out.println(a + n - t);
		}
	}

}
