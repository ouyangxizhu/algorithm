package primary.otherss;
/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

示例 :

输入: 11
输出: 3
解释: 整数 11 的二进制表示为 00000000000000000000000000001011
 

示例 2:

输入: 128
输出: 1
解释: 整数 128 的二进制表示为 00000000000000000000000010000000
 * @author ouyangxizhu
 *
 */
public class First {
	 // you need to treat n as an unsigned value
	/**
	 * https://blog.csdn.net/qq_34691713/article/details/80343773
	 * @param n
	 * @return
	 */
    public int hammingWeight(int n) {
        String bs = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < bs.length(); i++) {
			if (bs.charAt(i)=='1') {
				count++;
			}
		}
        return count;
    }
    /**
     * https://blog.csdn.net/RBreeze/article/details/81349019
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int flag = 1;
        int count = 0;
        while(flag!=0){
        	if ((flag&n)!=0) {
				count++;
			}
        	flag=flag<<1;
        }
        return count;
    }
    /**
     * https://blog.csdn.net/RBreeze/article/details/81349019
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while(n!=0){
        	count++;
        	n=n&(n-1);
        }
        return count;
    }
    /**
     * https://blog.csdn.net/yu849893679/article/details/81485304
     * 超时
     */
    public int hammingWeight3(int n) {
        int count = 0;
        while(n!=0){
        	if (n%2==1) {
				
        		count++;
			}
        	n=n>>1;
        }
        return count;
    }
}
