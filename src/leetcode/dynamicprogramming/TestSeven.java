package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestSeven {
	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
	
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> li = new ArrayList<>();
		li.add(list);
		
		for (int i = 0; i < nums.length; i++) {
			int size = li.size(); 
			for (int j = 0; j < size; j++) {
				list = li.get(j);
				ArrayList<Integer> list2 =new ArrayList<Integer>();
				for (int k = 0; k < list.size(); k++) {
					list2.add(list.get(k));
				}
				list2.add(nums[i]);
				li.add(list2);
			}
			
		}
		System.out.println(li);
	}
	
}
