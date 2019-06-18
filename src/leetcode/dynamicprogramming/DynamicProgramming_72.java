package dynamicprogramming;

/*
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *'A' -> 1
'B' -> 2
...
'Z' -> 26

给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
/*
 * 这道题的关键在于推导出递推公式，这里我将存储的数组定义为code，字符串为s，
 * code[i]代表前i个字符可解码的数量，即code[i]代表的是s[i-1]及之前字符的总解码数量。

很明显可知code[i]的值与code[i-1]、code[i-2]都有关，
当出现诸如s[i-1]='2'且s[i-2]='1'的情况时，code[i]=code[i-1]+code[i-2]，否则code[i]=code[i-1]。
这里是因为“12”具有“1”+“2”和“12”两种解码方式，
因此code[i]=code[i-1]（代表s[i-1]='2'的情况，即只解码自己本身的情况）
			+code[i-2]（代表s[i-1]='2'且s[i-2]='1'的情况，即解码自己加上上一个字符解码的情况）。
除此之外，还需要注意当s[i-1]='0'时code[i-1]=0的情况，因为s[i-1]='0'时它本身是不能进行解码的，因此code[i-1]必须设为0。
 */
public class DynamicProgramming_72 {
	public int numDecodings(String s) {
		if (s.length()==0||s==null) {
			return 0;
		}
		char [] ch= s.toCharArray();
		
        int [] ans = new int[s.length()+1];
        ans[0]=1;
        
        for (int i = 1; i < s.length()+1; i++) {
			if (ch[i-1]=='0') {
				ans[i-1]=0;
			}
			if ((i>1&&ch[i-2]=='1')||(i>1&&ch[i-1] >= '0'&&ch[i-2]=='2'&&ch[i-1]<='6')) {
				ans[i]=ans[i-1]+ans[i-2];
			}else {
				ans[i]=ans[i-1];
			}
		}
        return ans[s.length()];
    }
        
}
