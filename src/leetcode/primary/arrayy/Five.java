package primary.arrayy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �����������飬��дһ���������������ǵĽ�����

ʾ�� 1:

����: nums1 = [1,2,2,1], nums2 = [2,2]
���: [2,2]
ʾ�� 2:

����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
���: [4,9]
˵����

��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡�
���ǿ��Բ�������������˳��
����:

��������������Ѿ��ź����أ��㽫����Ż�����㷨��
��� nums1 �Ĵ�С�� nums2 С�ܶ࣬���ַ������ţ�
��� nums2 ��Ԫ�ش洢�ڴ����ϣ������ڴ������޵ģ������㲻��һ�μ������е�Ԫ�ص��ڴ��У������ô�죿
 * @author ouyangxizhu
 *
 */
public class Five {
	 public int[] intersect(int[] nums1, int[] nums2) {
		 //�洢���õ�������
		 List<Integer> list = new ArrayList<Integer>();
		 //�洢nums1ÿ��Ԫ�س��ֵĴ�����ʣ��Ĵ���
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 
		 for (int i = 0; i < nums1.length; i++) {
			Integer count = map.get(nums1[i]);
			map.put(nums1[i], count==null? 1:count+1);
		}
		 for (int j = 0; j < nums2.length; j++) {
			if (map.containsKey(nums2[j])&&map.get(nums2[j])>0) {
				list.add(nums2[j]);
				map.put(nums2[j], map.get(nums2[j])-1);
			}
		}
		 int [] ans = new int [list.size()];
		 for (int k = 0; k < ans.length; k++) {
			ans[k] = list.get(k);
		}
		 return ans;
	 }
	 /**
		 *  Sort array and judge whether equals from 0 to the smaller array's size
		 *  this method is suitable for the large different size between two arrays. 
		 * @param nums1
		 * @param nums2
		 * @return result 
		 */
		public static int[] intersect2(int[] nums1, int[] nums2) {
			List<Integer> list = new ArrayList<Integer>();
	 
			Arrays.sort(nums1);
			Arrays.sort(nums2);
	 
			int i = 0;
			int j = 0;
	 
			if (i < nums1.length && j < nums2.length) {
				if (nums1[i] == nums2[j]) {
					list.add(nums1[i]);
					j++;
					i++;
				} else if (nums1[i] > nums2[j]) {
					j++;
				} else if (nums1[i] < nums2[j]) {
					i++;
				}
			}
	 
			int[] result = new int[list.size()];
	 
			for (int k = 0; k < list.size(); k++) {
				result[k] = list.get(k);
			}
	 
			return result;
		}

}
