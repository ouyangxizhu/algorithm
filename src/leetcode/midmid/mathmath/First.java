package midmid.mathmath;

import java.util.HashSet;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
如果可以变为 1，那么这个数就是快乐数。

示例: 

输入: 19
输出: true
解释: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * @author ouyangxizhu
 *
 */
public class First {
	/**
	 * 分析：整个算法的设计分为两步

                     第一步：求数下一个平方计算后的数。

                     第二步：判断数值是否是快乐数。

         解法一：分两步进行，第一步计算下一个数，第二步做判断，可以利用一个容器保存计算过的数，只要出现1就直接返回是，如果出现重复的非1的数，就直接返回不是，其他情况继续。
--------------------- 
作者：guozhenqiang1992 
来源：CSDN 
原文：https://blog.csdn.net/guozhenqiang19921021/article/details/51914575 
版权声明：本文为博主原创文章，转载请附上博文链接！
	 */
	public boolean isHappy(int n) {
		if (n==1) {
			return true;
		}
		if (n<1) {
			return false;
		}
		int temp = n;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(temp);
		while (true) {
			temp = getNext(temp);
			if (temp==1) {
				return true;
			}
			if (hashSet.contains(temp)) {
				return false;
			}
			hashSet.add(temp);
			
			
		}
		
        
    }
	public static int getNext(int num) {
		int result = 0;
		while (num!=0) {
			result += (num%10)*(num%10);
			num = num/10;
		}
		return result;
	}

}
