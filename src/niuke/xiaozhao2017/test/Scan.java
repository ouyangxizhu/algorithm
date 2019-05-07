package niuke.xiaozhao2017.test;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Scan {
	public static class Node implements Comparable<Node>{
		int low, high, price;
		public Node(int low, int high, int price) {
			this.low = low;
			this.high = high;
			this.price = price;
		}
		@Override
		public int compareTo(Node o) {
			return this.low - o.low;
		}
		@Override
		public String toString() {
			return "[" + low + ", " + high + ", " + price + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Object> que = new PriorityQueue<>();
		while (sc.hasNext()) {
			String s = sc.nextLine();
			String[] str = s.trim().split(" ");
			int[] a = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				a[i] = Integer.valueOf(str[i]);
			}
			que.add(new Node(a[0], a[1], a[2]));

		}
		sc.close();
	}
}
