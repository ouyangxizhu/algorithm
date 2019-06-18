package primary.design;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
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
