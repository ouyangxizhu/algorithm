package Tencent.First;
/*
 * ��������Ϊ n ���������� nums������ n > 1������������� output ������ output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���

ʾ��:

����: [1,2,3,4]
���: [24,12,8,6]
˵��: �벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣

���ף�
������ڳ����ռ临�Ӷ�����������Ŀ�𣿣� ���ڶԿռ临�Ӷȷ�����Ŀ�ģ�������鲻����Ϊ����ռ䡣��
 */
public class First_14 {
	 public int[] productExceptSelf(int[] nums) {
		int [] numm = new int [nums.length];
		for (int i = 0; i < numm.length; i++) {
			numm[i]=1;
		}
		 
		 for (int i = 1; i < nums.length; i++) {
			numm[i]=numm[i-1]*nums[i-1];//�洢�����ֵ���еĳ˻�
			
		}
		 int right=1;
		 for (int i = nums.length-1; i >=0; i--) {
			numm[i]*=right;
			right*=nums[i];
		}
		 return numm;
	        
	 }

}
