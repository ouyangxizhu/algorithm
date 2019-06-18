package First;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author ouyangxizhu
 *
 */
public class First_7 {
 
	
	public int threeSumClosest(int[] nums, int target) {
		 if (nums.length<3) {
			return 0;
		}
		 Arrays.sort(nums);
		 
		 int closest = nums[0]+nums[1]+nums[2];
		 int diff = Math.abs(closest-target);
		 for (int i = 0; i < nums.length-2; i++) {
			 int start = i+1;
			 int end = nums.length-1;
			 while (start<end) {
				int sum= nums[i]+nums[end]+nums[start];
				int newdiff = Math.abs(sum-target);
				if (newdiff<diff) {
					diff=newdiff;
					closest= sum;
					
				}
				if (sum>target) {
					end--;
				}else {
					start++;
				}
			}
			 
			
		 }
		 return closest;
	 }
	 
    

}
