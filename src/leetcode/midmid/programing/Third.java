package midmid.programing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。
 * @author ouyangxizhu
 *
 */
public class Third {
	/**
	 * 题解：呃，第一想法是递归加回溯找到组合最小值，又来了，刚写的组合总和 Ⅳ的第一想法就是递归加回溯，不过结局比较惨，时间超限了。没有意外，本题在[1,2,5] 100这条数据就超时了，总共过了15条数据，呵呵，有时候思路正确并不一定能完美解题。好吧，还是动规登场，假设dp[i]为钱数为i时需要的最少硬币数，当i=0时，dp[0]=0,这个毫无疑问，当i>0时，直接说不好理解，那就举个实例，[1,2,3] 3 对这个例子来说，一种情况是只用1，数量是3，一种是用1和2，数量是2，最后是只用3，数量是1，那问题变成了，怎样使最终的结果为1，你可能说比较，好，谁和谁比较，呃。。。，换一个角度思考，对任意硬币coins[j]，我们有使用和不使用两种情况，所以比较的双方出来了，dp[i]代表使用coins[j]，dp[i-coins[j]]+1代表不使用coins[j],那么这里为什么又要加1呢，因为对i-coins[j]来说它加上一个coins[j]就是i了，所以这里需要加上1，然后i-coins[j]再从前一个状态判断最小值，最后直到已知值dp[0]。

其实真正的过程是i从0到amount记录每个状态的最小值，最后执行到dp[amount]时就是最后求的最小值，这也是动规真正的执行过程，不过我们习惯从最后开始分析问题，通过确定最后的状态与之前状态的关系，从而确定动态转移方程。

	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
        int n=coins.length;
        if(n==0||amount==0)
            return 0;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int j=0;j<n;j++){
            for(int i=coins[j];i<=amount;i++){
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];

	        
	}
	public static void main(String[] args) {
		int [] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(coinChange(coins, amount));
	}
	

}
