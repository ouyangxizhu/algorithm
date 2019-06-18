package midmid.programing;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

/**
 *  跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @author ouyangxizhu
 *
 */
public class First {
	public boolean canJump(int[] nums) {
		boolean dp[] = new boolean [nums.length];
		dp[nums.length-1] = true;
		for (int i = nums.length-2; i >= 0; i--) {
			if (i+nums[i]>=nums.length - 1) {
				dp[i] = true;
			}
			for (int j = i; j < nums.length - 1; j++) {
                //设置为true的条件是：
                //1.借助的j点必须为true
                //2.必须能够跳到j点来(i + A[i] >= j)
                if (dp[j] && i + nums[i] >= j) {
                    dp[i] = true;
                }
            }
		}
		return dp[0];
	
    }

}
