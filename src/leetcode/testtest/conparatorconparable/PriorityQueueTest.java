package testtest.conparatorconparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {
	public static void main(String args[]) {
		PriorityQueue<People> queue = new PriorityQueue<People>();
		List<People> list = new ArrayList<People>();
		for (int i = 1; i <= 10; i++) {
			People people = new People("уе" + i, (new Random().nextInt(100)));
			
			queue.add(people);
			list.add(people);
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.poll().toString());
		}
		Collections.sort(list,(a,b)->a.age-b.age);
		for (People peo : list) {
			System.out.println(peo.toString());
		}
	}

}
