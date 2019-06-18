package moni;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
	static ArrayList<Integer> list1 = new ArrayList();
	static ArrayList<Integer> list2 = new ArrayList();
	static int x1 = 0;
	static int y1 = 0;
	static int x2 = 0;
	static int y2 = 0;
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
        	list1.add(sc.nextInt());
			list2.add(sc.nextInt());

		}
		n = sc.nextInt();
		for (int j = 0; j < n; j++){
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			count(x1, y1, x2, y2);
		}
  
        sc.close();
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	private static void count(int x1, int y1, int x2, int y2) {
		int sum = 0;
		for(int i = 0; i < list1.size(); i++){
			if(list1.get(i) >= x1 && list1.get(i) <= x2 && list2.get(i) >= y1 && list2.get(i) <= y2)
				sum++;
		}
		System.out.println(sum);

	}

}
