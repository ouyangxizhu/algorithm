package Tencent.Third;

import java.util.Arrays;

/**
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�

˵����

����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����

ʾ�� 1:

����: [2,2,1]
���: 1
ʾ�� 2:

����: [4,1,2,1,2]
���: 4
 * @author ouyangxizhu
 *
 */

public class Third_3 {
	public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i++) {
        	if (nums[i]!=nums[i-1]) {
        		if (i==1) {
					return nums[0];
				}
        		if (nums[i]!=nums[i+1]) {
					return nums[i];
				}
			}
		
        }
        return nums[nums.length-1];
    }

}
