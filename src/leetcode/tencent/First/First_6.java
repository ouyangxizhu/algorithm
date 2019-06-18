package First;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ��
 * �ҳ��������������Ҳ��ظ�����Ԫ�顣
 * ����, �������� nums = [-1, 0, 1, 2, -1, -4]��
 * ����Ҫ�����Ԫ�鼯��Ϊ��
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
