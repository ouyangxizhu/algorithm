package niuke.xiaozhao2017.test;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Scan2 {
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
		PriorityQueue<Object> q = new PriorityQueue<>();
		while (sc.hasNext()) {
			int low = sc.nextInt();
			int high = sc.nextInt();
			int price = sc.nextInt();
			q.add(new Node(low, high, price));

		}
		sc.close();
		System.out.println(q.poll());
		
	}
}
