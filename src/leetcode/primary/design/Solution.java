package primary.design;

import java.util.Arrays;
import java.util.Random;

/**
 * ����һ��û���ظ�Ԫ�ص����顣

ʾ��:

// �����ּ��� 1, 2 �� 3 ��ʼ�����顣
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// �������� [1,2,3] �����ؽ�����κ� [1,2,3]�����з��صĸ���Ӧ����ͬ��
solution.shuffle();

// �������鵽���ĳ�ʼ״̬[1,2,3]��
solution.reset();

// �����������[1,2,3]���Һ�Ľ����
solution.shuffle();
 * @author ouyangxizhu
 *
 */
public class Solution { 
	private int [] orginalNums = null; 
	private int [] currentNums = null; 
	private static Random random = new Random();
	 public Solution(int[] nums) {
        orginalNums = nums;
		
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	return orginalNums;
        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int n = currentNums.length;
    	currentNums = Arrays.copyOf(orginalNums, n);
        for (int i = 0; i < n; i++) {
			int t = i + random.nextInt(n-i);
			int temp = currentNums[i];
			currentNums[i]=currentNums[t];
			currentNums[t]=temp;
		}
        return currentNums;
    }
}
