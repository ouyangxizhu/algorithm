package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
 * ����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����

˵�����⼯���ܰ����ظ����Ӽ���

ʾ��:

����: nums = [1,2,3]
���:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

public class Six {
	public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> li = new ArrayList<>();
        li.add(list);
        
        for (int i = 0; i < nums.length; i++) {
			int size = li.size();
			for (int j = 0; j < size; j++) {
				list = li.get(j);
				list.add(nums[i]);
				li.add(list);
			}
			
		}
        return li;
    }
}
