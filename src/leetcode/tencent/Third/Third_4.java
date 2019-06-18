package Tencent.Third;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
 * @author ouyangxizhu
 *
 */
public class Third_4 {
	public int majorityElement(int[] nums) {
		if (nums.length==1) {
			return nums[0];
		}else {
			int count = 1;
			Arrays.sort(nums);
			int value = nums[0];
			for (int i = 0; i < nums.length-1; i++) {
				if (value==nums[i+1]) {
					count++;
				}else {
					if (count>=1) {
						count--;
					}
				}
				if (count<1) {
					
					value = nums[i+1];
					count = 1;	
				}
					
				
			}
			return value;
		}
    }

}
