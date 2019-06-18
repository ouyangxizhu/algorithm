package Tencent.First;
/*
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
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
