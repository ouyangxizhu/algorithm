package Arrayy;
/*
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

ʾ��:

����: [0,1,0,3,12]
���: [1,3,12,0,0]
˵��:

������ԭ�����ϲ��������ܿ�����������顣
�������ٲ���������
 */
public class MoveZero {
	public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i]==0) {
				zeroCount++;
			}else if(zeroCount!=0){
				nums[i-zeroCount]=nums[i];
				nums[i]=0;
			}
		}
        
    }
}
