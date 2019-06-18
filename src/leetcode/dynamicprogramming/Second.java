package dynamicprogramming;
/*
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�

ʾ��:

����: [-2,1,-3,4,-1,2,1,-5,4],
���: 6
����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
����:

������Ѿ�ʵ�ָ��Ӷ�Ϊ O(n) �Ľⷨ������ʹ�ø�Ϊ����ķ��η���⡣
 */
public class Second {
	 public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int segmentSum = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            segmentSum = Math.max(nums[i], segmentSum + nums[i]);
            res = Math.max(res, segmentSum);
        }
        return res;
    }
}
