package pinduoduo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
        int n = sc.nextInt();
        int d = sc.nextInt();
        int location = 0;
        int money = 0;
        int[] a = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            location = sc.nextInt();
            money = sc.nextInt();
            a[i] = location;
            hashMap.put(location, money);
        }
        Arrays.sort(a);
        if (a[a.length -1] - a[0] < d) {
        	System.out.println(0);
			return;
		}
        for (int i = 0; i < n ; i++) {
        	
			for (int j = i + 1; j < n-1; j++) {
				if (a[j] - a[i] >= d) {
					
					max = Math.max(max, hashMap.get(a[i]) + hashMap.get(a[j]));
				}
			}
		}
        System.out.println(max);
        
    }

}
