package niuke.xiaozhao2017.didi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 题目描述
某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 
有m批客人，每批客人有两个参数:b人数，c预计消费金额。 
在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
输入描述:
输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 
第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。 
接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
输出描述:
输出一个整数,表示最大的总预计消费金额
示例1
输入
复制
3 5 2 4 2 1 3 3 5 3 7 5 9 1 10
输出
复制
20
 * @author changzhen.zhang
 *
 */
public class DiDi2arr {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] desk = new int[n];
			for (int i = 0; i < n; i++) {
				desk[i] = sc.nextInt();
			}
			Arrays.sort(desk);
			PriorityQueue<Customer> q = new PriorityQueue<Customer>();
			for (int i = 0; i < m; i++) {
				int b = sc.nextInt();
				int c = sc.nextInt();
				q.add(new Customer(b, c));
				
			}
			long sum = 0;
			while (!q.isEmpty()) {
				Customer customer = q.poll();
				if (isAble(desk, customer.getNum())) {
					sum += customer.money;
				}
			}
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	private static boolean isAble(int[] desk, int num) {
		for (int i = 0; i < desk.length; i++) {
			if (desk[i] >= num) {
				desk[i] = 0;
				return true;
			}
		}
		return false;
	}
	static class Customer implements Comparable<Customer>{
		private int num;
		private int money;
		
		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}

		public Customer(int num, int money) {
			this.num = num;
			this.money = money;
		}

		@Override
		public int compareTo(Customer o) {
			return o.money - this.money;
		}
		
	}
}
