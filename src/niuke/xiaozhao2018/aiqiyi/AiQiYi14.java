package niuke.xiaozhao2018.aiqiyi;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *题目描述
 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 输入描述:
 输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割
 输出描述:
 如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
 示例1
 输入

 复制
 1010 3 101010 2
 输出

 复制
 Equal
 * @author ouyangxizhu
 *
 */
public class AiQiYi14 {
	/**
	 * 
	 * @param args
	 */

	public static void main(String []args){
		Scanner in=new Scanner(System.in);
		String s1=in.next(),s2,a="",b="";
		int k1=in.nextInt(),k2,i;
		s2=in.next();k2=in.nextInt();
		for(i=0;i<k1;i++) a+=s1;
		for(i=0;i<k2;i++) b+=s2;
		BigInteger x=new BigInteger(a),y=new BigInteger(b);
		System.out.printf("%s",x.compareTo(y)>0?"Greater":x.compareTo(y)<0?"Less":"Equal");
	}

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in1 = sc.next(); int k1 = sc.nextInt(); String in2 = sc.next(); int k2 = sc.nextInt();
		StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
		for (int i=0; i!=k1; i++) {
			sb1.append(in1);
		}
		for (int i=0; i!=k2; i++) {
			sb2.append(in2);
		}
		String o1 = sb1.toString(), o2 = sb2.toString();
		if (o1.length() > o2.length()) {
			System.out.println("Greater");
		}
		else if (o1.length() < o2.length()) {
			System.out.println("Less");
		}
		else {
			if (o1.compareTo(o2) > 0) {
				System.out.println("Greater");
			}
			else if (o1.compareTo(o2) < 0){
				System.out.println("Less");
			}
			else {
				System.out.println("Equal");
			}
		}
		return;
	}

}
