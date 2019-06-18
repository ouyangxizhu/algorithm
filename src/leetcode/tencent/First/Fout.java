package tencenttencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Fout {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
           arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
			list.add(arr[i]) ;
		}
        System.out.println(count(list, m));
    }

	public static int count(List<Integer> list, int m) {
		Set<Integer> hashSet = new HashSet<Integer>();
		int result = -1;
		int start = 0;
		int end = 0;
		for (int i = 0; i < list.size(); i++) {
			hashSet.add(list.get(i));
		}
		if (hashSet.contains(0)) {
			hashSet.remove(0);
		}
		for (; start < list.size(); start++) {
			for (end = start +  m; end < list.size() - m; end++) {
				list.subList(start, end + 1);
				if (list.containsAll(hashSet)) {
					result = Math.max(result, end - start + 1);
				}
			}
		}
		return result;
	}

		
}
