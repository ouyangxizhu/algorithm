package niuke.xiaozhao2017.xiaomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 题目描述
继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"）， 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。
输入描述:
第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度在3到10000之间）。
输出描述:
输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。
示例1
输入
复制
4
EIGHT
ZEROTWOONE
OHWETENRTEO
OHEWTIEGTHENRTEO
输出
复制
0
234
345
0345
 * @author changzhen.zhang
 *
 */
public class Xiaomi1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			sHandler(str);
		}
	}

	private static void sHandler(String str) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		numCount(str, list);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}

	private static void numCount(String str, ArrayList<Integer> list) {
		int[] count = new int[10];

		count[0]=help(str,'Z');            //ZERO
        count[2]=help(str,'W');            //TWO
        count[4]=help(str,'U');            //FOUR
        count[1]=help(str,'O')-count[0]-count[2]-count[4];     //ONE
        count[6]=help(str,'X');            //SIX
        count[8]=help(str,'G');            //EIGHT
        count[3]=help(str,'T')-count[2]-count[8];        //TRHEE
        count[5]=help(str,'F')-count[4];           //FIVE
        count[7]=help(str,'V')-count[5];           //SEVEN
        count[9]=help(str,'I')-count[6]-count[5]-count[8];   //NINE 
        for (int i = 0; i < count.length; i++) {
        	int co = count[i];
			int num = (i + 2) % 10;
			for (int j = 0; j < co; j++) {
				list.add(num);
			}
		}
		
	}

	private static int help(String str, char c) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				sum ++;
			}
		}
		return sum;
	}

}
