package Tencent.First;
/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @author ouyangxizhu
 *
 */
public class First_11 {
	
	public String multiply(String num1, String num2) {
		if (num1 == "0" || num2 == "0")
	        return "0";
		char[] char1 = num1.toCharArray();
		char[] char2 = num2.toCharArray();
		
	    char[] ch = new char[num1.length()+num2.length()];
	    for (int i = 0; i < ch.length; i++) {
			ch[i]='0';
		}
	    
 	    for (int i = num2.length() - 1; i >= 0; --i) {
	        int mulflag = 0;//进制位
	        int addflag = 0;
	        for(int j = num1.length() - 1; j >= 0; --j) {
	            int temp1 = (char2[i]-'0')  * (char1[j]-'0')  + mulflag;//两个数相乘的值
	            mulflag = temp1 / 10;//两个数相乘后的进制位
	            temp1 = temp1 % 10;//两个数相乘后去除进制位后的数
	            int temp2 = ch[i + j + 1] - '0'+ temp1 + addflag;//addflag是每个位置单独相加后的进制位
	            ch[i + j + 1] = (char) ('0'+temp2 % 10);
	            addflag = temp2 / 10;//addflag是每个位置单独相加后的进制位
	        }
	        ch[i] += mulflag + addflag;
	    }
	
	    String str = new String(ch);
	    for (int i = 0; i < ch.length; i++) {
			if (ch[i]!='0') {
				str = str.substring(i,ch.length);
				return str;
			}
		}
	    return "0";

    }

}
