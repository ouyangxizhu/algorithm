package niuke.xiaozhao2017.test;

import java.util.Scanner;

public class Scan3 {

	public static void main(String[] args) {
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
	        sc.close();
	        System.out.println(prices);
	 
	    }

}
