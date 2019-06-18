package secondsearch.background;
/**
 * ���ֲ���
����һ�� n ��Ԫ������ģ������������� nums ��һ��Ŀ��ֵ target  ��дһ���������� nums �е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��


ʾ�� 1:

����: nums = [-1,0,3,5,9,12], target = 9
���: 4
����: 9 ������ nums �в����±�Ϊ 4
ʾ�� 2:

����: nums = [-1,0,3,5,9,12], target = 2
���: -1
����: 2 ������ nums ����˷��� -1
 

��ʾ��

����Լ��� nums �е�����Ԫ���ǲ��ظ��ġ�
n ���� [1, 10000]֮�䡣
nums ��ÿ��Ԫ�ض����� [-9999, 9999]֮�䡣

 * @author ouyangxizhu
 *
 */
public class First {
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = (start+end)/2;
		while (start<=end) {
			mid = (start+end)/2;
			if (target>nums[mid]) {
				start= mid+1;
			}else if (target < nums[mid]) {
				end = mid - 1;
			}else {
				return mid;
			}
			
		}
		return -1;
		
        
    }

}
