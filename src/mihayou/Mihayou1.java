package mihayou;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Mihayou1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int len = sc.nextInt();
			q.add(new Node(x, y, len));
		}
		int res = 0;
		int prex = 0;
		int prey = 0;
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			res += node.getLen() * node.getLen();
			if (node.getX() < prex && node.getY() < prey) {
				res -= (prex - node.getX()) * (prey - node.getY());
			}
			prex = node.getX() + node.getLen();
			prey = node.getY() + node.getLen();
		}
		System.out.println(res);
		
	}
	static class Node implements Comparable<Node>{
		private int x;
		private int y;
		private int len;
		
		public Node(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}

		
		public int getX() {
			return x;
		}


		public void setX(int x) {
			this.x = x;
		}


		public int getY() {
			return y;
		}


		public void setY(int y) {
			this.y = y;
		}


		public int getLen() {
			return len;
		}


		public void setLen(int len) {
			this.len = len;
		}


		@Override
		public int compareTo(Node o) {
			return this.x - o.x;
		}
		
	}

}
