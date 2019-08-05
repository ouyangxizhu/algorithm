package bishi2019.mihayou;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Mihayou2 {
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
		Node preNode = q.poll();
		long res = preNode.getLen() * preNode.getLen();
		int prex = preNode.x + preNode.len;
		int prey = preNode.y + preNode.len;
		while (!q.isEmpty()) {
			Node node = q.poll();
			res += node.getLen() * node.getLen();
			if (node.x < prex) {
				if (node.y < prey && node.y > preNode.y) {
					
					int m = Math.min(prex, node.x + node.len);
					int mm = Math.min(prey, node.y + node.len);
					res -= (m - node.x) * (mm - node.y);
				}else if (node.y < preNode.y && node.y + node.len > preNode.y) {
					int m = Math.min(prex, node.x + node.len);
					int mm = Math.min(prey, node.y + node.len);
		
					res -= (m - node.x) * (mm - preNode.y);
				}
			}
			prex = node.getX() + node.getLen();
			prey = node.getY() + node.getLen();
			preNode = node;
		}
		System.out.println(res);
		
	}
	static class Node implements Comparable<Node>{
		public int x;
		public int y;
		public int len;
		
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


		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", len=" + len + "]";
		}
		
		
	}

}
