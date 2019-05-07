package niuke.xiaozhao2018.aiqiyi;

import java.util.HashSet;
import java.util.Scanner;
/**
 * 题目描述
牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
例如:s = AGGTCTA
序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
输入描述:
输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。
输出描述:
输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
示例1
输入

复制
AGGTCTA
输出

复制
2
 * @author ouyangxizhu
 *
 */
public class AiQiYi2 {
	/**
	 * 把所有的加进hashset当size不为4的字符串长度幂时，返回
	 * @param args
	 */

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        if (str.length() == 1) {
			System.out.println(1);
			return;
		}
        for (int i = 1; i < str.length(); i++) {
			HashSet<String> hashSet = new HashSet<String>();
			for (int j = 0; j < str.length() - i; j++) {
				hashSet.add(str.substring(j, j + i));
			}
			if (hashSet.size() < Math.pow(4, i)) {
				System.out.println(i);
				break;
			}
		}
	}

}
