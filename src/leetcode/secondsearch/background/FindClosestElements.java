package secondsearch.background;

import java.util.ArrayList;
import java.util.List;

/**
 * �ҵ� K ����ӽ���Ԫ��
����һ������õ����飬�������� k �� x�����������ҵ���� x������֮����С���� k ���������صĽ������Ҫ�ǰ������źõġ�������������� x �Ĳ�ֵһ��������ѡ����ֵ��С���Ǹ�����

ʾ�� 1:

����: [1,2,3,4,5], k=4, x=3
���: [1,2,3,4]
 

ʾ�� 2:

����: [1,2,3,4,5], k=4, x=-1
���: [1,2,3,4]
 

˵��:

k ��ֵΪ������������С�ڸ�����������ĳ��ȡ�
���鲻Ϊ�գ��ҳ��Ȳ����� 104
�������ÿ��Ԫ���� x �ľ���ֵ������ 104
 

����(2017/9/19):
������� arr �Ѿ����ı�Ϊһ���������飨�����������б��� �����¼��ش��붨���Ի�ȡ���¸��ġ�
 * @author ouyangxizhu
 *
 */
public class FindClosestElements {
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
		 int left = 0;
		 int right = arr.length-1;
		 List<Integer> list = new ArrayList<Integer>();
		 while (right - left > k-1) {
			 int le = x-arr[left];
			 int ri = arr[right]-x;
			if (le>ri) {
				left++;
			}else {
				right--;
			}
		}
		 for (int i = left; i <= right; i++) {
			list.add(arr[i]);
		}
		 return list;
	        
	 }
	 

}
