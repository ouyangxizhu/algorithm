package zhaoshangyinhang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {
	static class Node implements Comparable<Node>{
		public int l;
		public int d;
		

		public Node(int l, int d) {
			this.l = l;
			this.d = d;
		}


		@Override
		public int compareTo(Node o) {
			return o.l - this.l;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] l = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < d.length; i++) {
			l[i] = sc.nextInt();
		}
		for (int i = 0; i < d.length; i++) {
			d[i] = sc.nextInt();
		}
		if (n == 1) {
			System.out.println(0);
			return;
		}
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		for (int i = 0; i < d.length; i++) {
			q.add(new Node(l[i], d[i]));
		}
		int m = (d.length + 1)/2;
		ArrayList<Node> list = new ArrayList<Node>();
		for (int i = 0; i < m; i++) {
			list.add(q.poll());
		}
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).l - list.get(list.size() - 1).l != 0) {
				
				sum += list.get(i).d;
			}
		}
		System.out.println(sum);
	}

}
