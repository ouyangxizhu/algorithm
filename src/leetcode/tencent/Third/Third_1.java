package Tencent.Third;
/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * @author ouyangxizhu
 *
 */
public class Third_1 {
	public int reverse(int x) {
		long a=0;//存储最后返回值
		int b;//存储位数；
		int m = x;
		if (m<0) {
			b=(m+"").length()-1;
		}
		else {
			b=(m+"").length();
		}
		
		for (int i = 0; i < b; i++) {
			if (m!=0) {
				int a1 = m%10;
				m=(m-a1)/10;
				a+=a1*Math.pow(10, b-i-1);
			
			}
			
			
		}
		if (a<Integer.MIN_VALUE||a>Integer.MAX_VALUE) {
			return 0;
		}
		return (int) a;
        
    }
	

}
