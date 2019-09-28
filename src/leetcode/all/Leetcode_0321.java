package leetcode.all;

import java.util.Stack;

/**
 * **做题思路 **:
 * 最终取出 K 个数，等价于从第一个数组中取出 i {i ->(0, Math.min(len1, K))} 个数，从第二个数组中取出 K - i (K - i <= len2)个数;
 * 可以拆分成以下子问题
 * <p>
 * 子问题1 :如何从一个数组中选择 k 个数组成的数最大 -> maxNum(int[] nums, int k)
 * 子问题2 :如何将两个数组组成一个数组使得组成的数最大 -> mergeNum(int[] num1, int[] num2) || 采用双指针归并，衍生问题是如果两个位置的数相同则需要进一步的处置 -> getNextStep(int[] num1, int[] num2, int l, int r)
 * 子问题3 :如何判断两个相同长度数组组成的数的大小 -> compareTo(int[] nums1, int[] nums2)
 */
public class Leetcode_0321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        if (nums1.length + nums2.length < k) {
            return res;
        }
        if (nums1.length > nums2.length) {
            return maxNumber(nums2, nums1, k);
        }
        int len = Math.min(nums1.length, k);
        for (int i = 0; i <= len; i++) {
            if (k - i > nums2.length) {
                continue;
            }
            int[] maxNum1 = maxSubNum(nums1, i);
            int[] maxNum2 = maxSubNum(nums2, k - i);
            int[] maxRes = mergeNum(maxNum1, maxNum2);
            res = compareMaxNum(maxRes, res);
        }
        return res;

    }


    //比较哪个大
    private int[] compareMaxNum(int[] num1, int[] num2) {
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] > num2[i]) {
                return num1;
            } else if (num1[i] < num2[i]) {
                return num2;
            }
        }
        return num1;
    }

    //合并成最大值
    private int[] mergeNum(int[] num1, int[] num2) {
        int index1 = 0, index2 = 0, index = 0;
        int[] res = new int[num1.length + num2.length];
        while (index1 < num1.length && index2 < num2.length) {
            if (num1[index1] > num2[index2]) {
                res[index++] = num1[index1++];
            } else if (num1[index1] < num2[index2]) {
                res[index++] = num2[index2++];
            } else {
                if (getNextStep(num1, num2, index1, index2)) {
                    res[index++] = num1[index1++];
                } else {
                    res[index++] = num2[index2++];
                }
            }
        }
        while (index1 < num1.length) {
            res[index++] = num1[index1++];
        }
        while (index2 < num2.length) {
            res[index++] = num2[index2++];
        }
        return res;
    }

    private boolean getNextStep(int[] num1, int[] num2, int index1, int index2) {
        if (index1 >= num1.length && index2 >= num2.length) {
            return true;
        }
        if (index1 >= num1.length) {
            return false;
        }
        if (index2 >= num2.length) {
            return true;
        }
        if (num1[index1] == num2[index2]) {
            return getNextStep(num1, num2, index1 + 1, index2 + 1);
        } else if (num1[index1] > num2[index2]) {
            return true;
        } else {
            return false;
        }

    }

    //找到由数组的k个数组成的最大的数组
    private int[] maxSubNum1(int[] nums, int k) {

        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek() && nums.length - i - 1 >= k - stack.size()) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.add(nums[i]);
            }
        }

        int index = 0;
        for (int num : stack) {
            res[index++] = num;
        }
        return res;
    }
    //这个比较快
    public int[] maxSubNum(int[] nums, int k){
        int[] res = new int[k];
        int l = 0, r = nums.length - k;
        for(int i = 0 ; i < k ; i ++){
            int[] max = getMaxNum(nums, l, r);
            res[i] = max[0];
            l = max[1] + 1;
            r = r + 1;
        }
        return res;
    }
    public int[] getMaxNum(int[] nums, int l, int r){
        int[] res = new int[2];
        int k = l;
        int max = -1;
        while(k <= r){
            if(nums[k] > max){
                max = nums[k];
                res[0] = max;
                res[1] = k;
                if(max == 9){
                    return res;
                }
            }
            k ++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2,5,6,4,4,0};
        int[] nums2 = new int[]{7,3,8,0,6,5,7,6,2};
        int[] res = new Leetcode_0321().maxNumber(nums1, nums2, 15);
        for (int num : res) {
            System.out.print(num + " ");
        }

    }
}
