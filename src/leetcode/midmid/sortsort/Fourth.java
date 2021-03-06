package midmid.sortsort;
/**
 * 寻找峰值
峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞。

示例 1:

输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
示例 2:

输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5 
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
说明:

你的解法应该是 O(logN) 时间复杂度的。
 * @author ouyangxizhu
 *	--------------------- 
	作者：Narasimha_Karumanchi 
	来源：CSDN 
	原文：https://blog.csdn.net/qq_14927217/article/details/72861323 
	版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class Fourth {
	 public int findPeakElement(int[] nums) {
		if (nums.length==2) {
			return nums[0]>nums[1]?0:1;
		}
		int result=0;
		for(int i=1;i<nums.length-1;i++){
			if(nums[i]>nums[i-1]){
				result=i;
				if (nums[i]>nums[i+1]) {
					break;
				}else {
					result = i+1;
				}	
			}
		}
		return result;
	 }

}
