package niuke.xiaozhao2018.zhaoshangyinhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
小明在卡中心工作，用到的很多系统账号都需要设置安全密码。密码如果符合以下规范可以称为安全密码：
1、密码至少包含6个字符，至多包含20个字符；
2、至少包含一个小写字母，至少包含一个大写字母，至少包含一个数字；
3、不能出现连续3个相同的字母。

请写一个检查密码是否为安全密码的函数。
输入为一个字符串作为密码，输出为将该密码改为安全密码的最小改变次数。如果它已经是安全密码，则返回0。
备注：插入、删除、或者替换一个字符，均视为改变一次。
输入描述:
输入为一个字符串作为密码。
输出描述:
输出为将该密码改为安全密码的最小改变次数。如果它已经是安全密码，则返回0。
示例1
输入

复制
aB3ab3
输出

复制
0
说明

示例2
输入

复制
aaaaaa
输出

复制
2
说明

示例3
输入

复制
abcdefG
输出

复制
1

 * @author ouyangxizhu
 *
 */
public class ZhaoShangYinHang6 {
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
