package niuke.xiaozhao2017.test;

import java.util.*;
 
public class Main {
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