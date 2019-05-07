package niuke.xiaozhao2017.test;

import java.util.PriorityQueue;

public class Compara implements Comparable<Compara>{
	int low;

	public Compara(int low) {
		this.low = low;
	}

	@Override
	public int compareTo(Compara o) {
		return this.low - o.low;
	}
	
	@Override
	public String toString() {
		return "Compara [low=" + low + "]";
	}

	public static void main(String[] args) {
		PriorityQueue<Compara> q = new PriorityQueue<Compara>();
		q.add(new Compara(0));
		q.add(new Compara(3));
		q.add(new Compara(1));
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
	}

}
