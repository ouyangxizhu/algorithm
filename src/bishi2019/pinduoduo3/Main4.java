package bishi2019.pinduoduo3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = n; i >= n - k; i--) {
			for (int j = m; j >= m - k; j--) {
				int tmp = i * j;
				if (q.size() < k) {
					q.add(tmp);
				} else {
					if (tmp > q.peek()) {
						q.poll();
						q.add(tmp);
					}
				}
			}
		}
		System.out.println(q.peek());
	}

}
