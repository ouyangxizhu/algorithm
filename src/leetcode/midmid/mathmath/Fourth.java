package midmid.mathmath;
/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
思路：

这道题用折半连乘来模拟指数函数，每次先算输入n/2的结果，然后判断当前是奇数还是偶数，如果是偶数就把n/2计算的结果乘以本身，如果是奇数就再乘以待乘数x，边界条件为当n==0时返回1。
应该先考虑清楚，再下笔coding。

    特殊情况：x取0时，0^n=0。 n不能为0和负数。

                      x取1时，1^n=1。

                      x^0=1。

                      x取负数时。n取负数时。

                      n取奇数时，n取偶数时。

    性能考虑：简单的做n次乘法，时间复杂度是O()。

     有没有O(log n)的方法呢？得二分思想了。这里的二分是指减少乘法的次数，把重复的运算省去。我要求x的n次方，那么先求x的n/2次方，然后两个相乘起来。如此递归下去。

 * @author ouyangxizhu
 *
 */
public class Fourth {
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1/helper(x, -n);
		}
		return helper(x, n);
	}
	double helper(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double half = helper(x, n / 2);
		if ((n & 1) == 1) {
			return half * half*x;
		}
		return half * half;
	}

}
