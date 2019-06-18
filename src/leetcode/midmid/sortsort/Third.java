package midmid.sortsort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * �����еĵ�K�����Ԫ��
��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�

ʾ�� 1:

����: [3,2,1,5,6,4] �� k = 2
���: 5
ʾ�� 2:

����: [3,2,3,1,2,4,5,5,6] �� k = 4
���: 4
˵��:

����Լ��� k ������Ч�ģ��� 1 �� k �� ����ĳ��ȡ�
 * @author ouyangxizhu
 *
 */
public class Third {
	//�ⷨһ��
    //ʱ�临�Ӷ� O(NlogN)���ռ临�Ӷ� O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);             //��С��������
        return nums[nums.length - k];  //������K��
    }
 
    //������ ��ʱ�临�Ӷ� O(NlogK)���ռ临�Ӷ� O(K)��
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //С����
        for (int val : nums) {
            pq.add(val);
            //ά���ѵĴ�СΪ K
            if (pq.size() > k) {
                pq.poll();  //����
            }
        }
        return pq.peek();
    }
 
    //����ѡ�� ��ʱ�临�Ӷ� O(N)���ռ临�Ӷ� O(1)
    public int findKthLargest3(int[] nums, int k) {
        k = nums.length - k;   //������k��λ��
 
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
