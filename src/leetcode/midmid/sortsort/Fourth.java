package midmid.sortsort;
/**
 * Ѱ�ҷ�ֵ
��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�

����һ���������� nums������ nums[i] �� nums[i+1]���ҵ���ֵԪ�ز�������������

������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�

����Լ��� nums[-1] = nums[n] = -�ޡ�

ʾ�� 1:

����: nums = [1,2,3,1]
���: 2
����: 3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
ʾ�� 2:

����: nums = [1,2,1,3,5,6,4]
���: 1 �� 5 
����: ��ĺ������Է������� 1�����ֵԪ��Ϊ 2��
     ���߷������� 5�� ���ֵԪ��Ϊ 6��
˵��:

��ĽⷨӦ���� O(logN) ʱ�临�Ӷȵġ�
 * @author ouyangxizhu
 *	--------------------- 
	���ߣ�Narasimha_Karumanchi 
	��Դ��CSDN 
	ԭ�ģ�https://blog.csdn.net/qq_14927217/article/details/72861323 
	��Ȩ����������Ϊ����ԭ�����£�ת���븽�ϲ������ӣ�
 */
public class Fourth {
	 public int findPeakElement(int[] nums) {
		if (nums.length==2) {
			return nums[0]>nums[1]?0:1;
		}
		int result=0;
		for(int i=1;i<nums.length-1;i++){
			if(nums[i]>nums[i-1]){
				result=i;
				if (nums[i]>nums[i+1]) {
					break;
				}else {
					result = i+1;
				}	
			}
		}
		return result;
	 }

}
