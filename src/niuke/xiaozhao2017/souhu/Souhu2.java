package niuke.xiaozhao2017.souhu;

import java.util.Scanner;

/**
 * 题目描述
有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，
但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，
我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。
如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。
输入描述:
我们用每种字符代表一种宝石，
A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，G代表玻璃等等，
我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。
每行代表一种情况。
输出描述:
输出学者能够拿到的最多的宝石数量。每行一个
示例1
输入
复制
ABCYDYE
ATTMBQECPD
输出
复制
1
3
 * @author changzhen.zhang
 *
 */
public class Souhu2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.next();
			if (str.length() < 5) {
				System.out.println(0);
			}
			count(str);
		}
		sc.close();
	}
	/**
	 * 字符串截取
	 * @param str
	 */
	private static void count(String str) {
		String s = str + str;//可以省去处理环
		for (int i = 5; i < str.length(); i++) {//表示截取的长度
			for (int j = 0; j < str.length(); j++) {//从哪个位置开始取 
				if (ifTrue(s.substring(j, j + i))) {
					System.out.println(str.length() - i);
					return;
				}
			}
		}
		System.out.println(0);
		
	}
	@SuppressWarnings("unused")
	private static void count1(String str) {
		char[] ch = str.toCharArray();
		for (int i = 5; i < str.length(); i++) {//表示截取的长度
			for (int j = 0; j < str.length(); j++) {
				StringBuilder sb = new StringBuilder();
				for (int j2 = j; j2 < i + j; j2++) {
					sb.append(ch[j2 % str.length()]);//取余就行了
				}
				if (ifTrue(sb.toString())) {
					System.out.println(str.length() - i);
					return;
				}
			}
		}
		System.out.println(0);
		
	}

	private static boolean ifTrue(String substring) {
		if(substring.contains("A")
				&& substring.contains("B")
				&& substring.contains("C")
				&& substring.contains("D")
				&& substring.contains("E")) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
