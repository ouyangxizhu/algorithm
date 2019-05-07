package niuke.xiaozhao2017.quna;

import java.util.HashMap;
import java.util.Scanner;



/**
 * 题目描述
给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符(需要区分大小写)。
输入描述:
输入数据一个字符串，包括字母,数字等。
输出描述:
输出首先出现三次的那个英文字符
示例1
输入
复制
Have you ever gone shopping and
输出
复制
e
 * @author changzhen.zhang
 *
 */
public class Quna4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		str.replace(" ", "");
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (hashMap.containsKey(str.charAt(i))) {
				if (hashMap.get(str.charAt(i)) == 2) {
					if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
						
						System.out.println(str.charAt(i));
						return;
					}
				}
				hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
			}else {
				hashMap.put(str.charAt(i), 1);
			}
		}
	}
}
