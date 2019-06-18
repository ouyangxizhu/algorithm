package First;

import java.util.Arrays;

/**
 * ����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������
 * ʹ�����ǵĺ��� target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 * ���磬�������� nums = [-1��2��1��-4], �� target = 1.
 * �� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).
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
