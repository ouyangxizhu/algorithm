package Tencent.First;

import javax.swing.JInternalFrame;

/**
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * ʾ�� 1:
 * �������� nums = [1,1,2], 

����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2�� 

�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
ʾ�� 2:

���� nums = [0,0,1,1,1,2,2,3,3,4],

����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��

�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * @author ouyangxizhu
 *
 */
public class First_9 {
	public static void main(String[] args) {
		int[] nums ={1,1,2};
		int en = removeDuplicates(nums);
		System.out.println(en);
		System.out.println(nums);
	}
	public static int removeDuplicates(int[] nums) {
		int end = 1;//��ʾ��ǰ���������ĵ�λ��
		for (int i = 1; i < nums.length; i++) {
			boolean bo = true;
			for (int j = 0; j < end; j++) {
				if (nums[i]==nums[j]) {
					bo = false;
					 break;	
				}
				
			}
			if (bo) {
				nums[end++]=nums[i];
			}
		}
		return end;
        
    }

}
