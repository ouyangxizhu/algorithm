package testtest;

import java.util.PriorityQueue;
import java.util.Scanner;

public class TestPriority {
	public static void main(String[] args) {
		int [] arr = {1, 2 , 5,6,8,7,4,9,5,1,6,2,7,8};
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> q2 = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
			q2.add(arr[i]);
		}
		while (!q.isEmpty()) {
			System.out.print(q.poll() + ",");
		}
		System.out.println();
		while (!q2.isEmpty()) {
			System.out.print(q2.poll() + ",");
		}
	}

}
