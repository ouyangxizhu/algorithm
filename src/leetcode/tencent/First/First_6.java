package First;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @author ouyangxizhu
 *
 */

public class First_6 {
	List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
	 public List<List<Integer>> threeSum (int[] nums) {
		 if (nums.length<3) {
			return ret ;
		}
		 Arrays.sort(nums);
		 for (int i = 0; i < nums.length-2; i++) {
			 twoSum(nums,i+1,0-nums[i]);
			 while(i < nums.length - 2 && nums[i] == nums[i+1]){
				 ++i;
				 
			 }
			
		}
		 return ret;
		 
		 
	
	 }
	 public void twoSum(int []nums, int start,int value){
		 int beg = start;
		 int end = nums.length-1;
		 while (beg<end) {
			if (nums[beg]+nums[end]==value) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[start-1]);
				list.add(nums[beg]);
				list.add(nums[end]);
				ret.add(list);
				while (beg<end&&nums[end]==nums[end-1]){
					end--;
				}
				while (beg<end&&nums[beg]==nums[beg+1]){
					beg++;
				}
				end--;
				beg++;
			}else if (nums[beg]+nums[end]>value) {
				end--;
			}else {
				beg++;
			}
		}
		 
		 
	 }
	

}
