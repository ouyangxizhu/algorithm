package primary.mathmath;
/**
 * 统计所有小于非负整数 n 的质数的数量。

示例:

输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @author ouyangxizhu
 *
 */
public class Second {
	 public int countPrimes(int n) {
		 if (n<=2) {
			return 0;
		}
		 boolean[] origin = new boolean[n];
		 for (int i = 0; i <= n; i++) {
			origin[i]=true;
		}
		 for (int i = 2; i < n; i++) {
			if (origin[i]) {
				int temp = i+i;
				while (temp < n) {
					origin[temp] = false;
					temp +=i;
				}
			}
		}
		 int result = 0;
		 for (int i = 2; i < n; i++) {
			if (origin[i]) {
				result++;
			}
			
		}
		 return result;
	        
	 }
	 
}
