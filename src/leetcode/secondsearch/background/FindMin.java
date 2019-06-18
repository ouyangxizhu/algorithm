package secondsearch.background;
/**
 * Ѱ����ת���������е���Сֵ
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��

���ҳ�������С��Ԫ�ء�

����Լ��������в������ظ�Ԫ�ء�

ʾ�� 1:

����: [3,4,5,1,2]
���: 1
ʾ�� 2:

����: [4,5,6,7,0,1,2]
���: 0
 * @author ouyangxizhu
 *
 */
public class FindMin {
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		int mid = left + (right-left)/2;
		if (nums[right]>nums[left]) {
			return nums[left];
		}
		while (left < right) {
			mid = left + (right-left)/2;
			if (nums[mid]>nums[right]) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		 return nums[left];
        
    }

}
