package Tencent.First;
/*
 * �������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣

˵��:

��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
ʾ��:

����:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

���: [1,2,2,3,5,6]
 */
public class First_18 {
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
		 int [] nums = new int[m+n];
		 int end1= m-1;
		 int end2= n-1;
		 int end = m+n-1;
		 while (end1>=0&&end2>=0) {
			 if (nums1[end1]>nums2[end2]) {
				nums[end--]=nums1[end1--];
			}else {
				nums[end--]=nums2[end2--];
			}	
		 }
		 while (end1>=0) {
			 nums[end--]=nums1[end1--];
		}
		 while (end2>=0) {
			 nums[end--]=nums2[end2--];
		}
		for (int i = 0; i < nums.length; i++) {
			nums1[i]=nums[i];
		}
	 }
}
