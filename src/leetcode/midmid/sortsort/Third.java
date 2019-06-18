package midmid.sortsort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @author ouyangxizhu
 *
 */
public class Third {
	//解法一：
    //时间复杂度 O(NlogN)，空间复杂度 O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);             //从小到大排序
        return nums[nums.length - k];  //倒数第K个
    }
 
    //堆排序 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //小顶堆
        for (int val : nums) {
            pq.add(val);
            //维护堆的大小为 K
            if (pq.size() > k) {
                pq.poll();  //弹出
            }
        }
        return pq.peek();
    }
 
    //快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)
    public int findKthLargest3(int[] nums, int k) {
        k = nums.length - k;   //倒数第k个位置
 
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            else if (j < k)
                l = j + 1;
            else
                h = j - 1;
        }
        return nums[k];
    }
    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }
 
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }



}
