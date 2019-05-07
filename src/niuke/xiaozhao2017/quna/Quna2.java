package niuke.xiaozhao2017.quna;

import java.util.PriorityQueue;
import java.util.Scanner;




/**
 * 题目描述
酒店房间的价格录入是通过时间段来录入的，比如10月1日至10月7日800元，10月8日至10月20日500元，请实现以下函数int[][] merge(int[][] dateRangePrices)，输入是某个酒店多个日期段的价格，每个日期段（终止日期大于等于起始日期）和对应的价格使用长度为3的数组来表示，比如[0, 19, 300], [10, 40, 250]分别表示从某天开始第1天到第20天价格都是300，第11天到第41天价格都是250，这些日期端有可能重复，重复的日期的价格以后面的为准， 请以以下规则合并并输出合并结果：
1.相邻两天的价格如果相同，那么这两个日期段应该合并
2.合并的结果应该以起始日期从小到大排序
输入描述:
输入数据包括多行，如样例输入所示。
输出描述:
输出数据为一行，如样例输出所示
示例1
输入
复制
1 1 100
2 3 100
4 5 110
输出
复制
[1, 3, 100],[4, 5, 110]
 * @author changzhen.zhang
 *
 */
public class Quna2 {
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
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		while (sc.hasNextLine()) {
			int low = sc.nextInt();
			int high = sc.nextInt();
			int price = sc.nextInt();
			que.add(new Node(low, high, price));
		}
		sc.close();
	
		merge(que);
	}

	/*
	 * private static int[] lineToArray(String s) { String[] str =
	 * s.trim().split(" "); int[] a = new int[str.length]; for (int i = 0; i <
	 * str.length; i++) { a[i] = Integer.valueOf(str[i]); } return a; }
	 */
	private static void merge(PriorityQueue<Node> que) {
		if (que.isEmpty()) {
			return;
		}
		Node node1 = (Node) que.poll();
		while(!que.isEmpty()) {
			Node node2 = que.poll();
			if ((node2.low - node1.high) <= 1) {
				if (node1.price == node2.price) {
					node1 = new Node(node1.low, node2.high, node1.price);
				}else {
					node1 = new Node(node1.low, node2.low - 1, node1.price);
					System.out.print(node1);
					node1 = node2;
					if (!que.isEmpty()) {
						System.out.print(",");
					}
				}
			}else {
				System.out.print(node1);
				node1 = node2;
				if (!que.isEmpty()) {
					System.out.print(",");
				}
			}
		}
	}
	/**
	 * 另一种算法
	 * @param args
	 */
	public static void main2(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // 储存每一个的价格,列表索引为天数，element为价格
	        int[] prices = new int[12000];
	        while (sc.hasNext()) {
	            //更新价格数组
	            int start = sc.nextInt();
	            int end = sc.nextInt();
	            int price = sc.nextInt();
	            for (int i = start; i <= end; i++) {
	                prices[i] = price;
	            }
	        }
	        System.out.print(handle(prices));
	 
	    }
	 
	    public static StringBuffer handle(int[] prices) {
	        StringBuffer buf = new StringBuffer();
	        int size = prices.length;
	        int i = 0;
	        int lastDay = 0;
	        while (i < size) {
	            int currentPrice = prices[i];
	            i++;
	            while (i < size && currentPrice == prices[i]) {
	                //价格跟之前一样，我们继续增加索引
	                i++;
	            }
	            // 此时的i为新的价格的第一天;
	            int current = i;
	            if (prices[current - 1] != 0) {
	                buf.append("[").append(lastDay).append(", ").append(current - 1).append(", ")
	                        .append(prices[current - 1]).append("]").append(",");
	            }
	            lastDay = i;
	        }
	        //删除最后一个逗号
	        return buf.deleteCharAt(buf.length() - 1);
	 
	    }

}
