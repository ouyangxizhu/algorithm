package midmid.mathmath;
/**
 * 问题描述

给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:

输入: 3 
输出: 0 
解释: 3! = 6, 尾数中没有零。 
示例 2:

输入: 5 
输出: 1 
解释: 5! = 120, 尾数中有 1 个零. 
说明: 你算法的时间复杂度应为 O(log n) 。

问题分析

要求末尾有多少个零，则该数应为x*10k 的形式等于x*（2k *5k） 
也就是求该数分解质因子后有几个5就行，：如1*2*3*4*5=1*2*3*2*2*5（里面有一个5）所以结果为1个0。
--------------------- 
作者：wangxizzz 
来源：CSDN 
原文：https://blog.csdn.net/qq_36387730/article/details/81669845 
版权声明：本文为博主原创文章，转载请附上博文链接！
 * @author ouyangxizhu
 *
 */
public class Second {
	 public int trailingZeroes(int n) {
	     if (n<5) {
			return 0;
		}
	     int result = 0;
	     while (n!=0) {
			result += n/5;
			n = n/5;
			
		}
	     return result;
	 }

}
