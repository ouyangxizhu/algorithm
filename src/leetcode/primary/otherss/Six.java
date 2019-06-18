package primary.otherss;
/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * @author ouyangxizhu
 *我们就简单把这道题当成一道数学题来算就可以了，因为是连续的，
 *所以不缺失数字时候的加和可以计算，缺失数字之后的加和遍历一遍也可以计算出来，
 *二者相减不就是缺失的数字了，额
 */
public class Six {
	public int missingNumber(int[] nums) {
        int res=nums.length;
        for(int i=0;i<nums.length;i++){
            res +=(i-nums[i]);
        }
        return res;
    }

}
