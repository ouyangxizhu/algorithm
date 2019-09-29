package leetcode.all;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode_0502 {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (Profits == null || Profits.length == 0) {
            return W;
        }
//        PriorityQueue<int[]> capPq = new PriorityQueue<>(Comparator.comparing(o -> o[0]));//成本从小到大排列
//        PriorityQueue<int[]> proPq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);//利润从大大小排列
        //这种方式更快
        PriorityQueue<int[]> capPq = new PriorityQueue<>(new capComparator());//成本从小到大排列
        PriorityQueue<int[]> proPq = new PriorityQueue<>(new proComparator());//利润从大大小排列
        for (int i = 0; i < Profits.length; i++) {
            capPq.offer(new int[]{Capital[i], Profits[i]});
        }
        while (k-- != 0) {
            //每次将所有成本小于W的都取出放到利润队列里面，之后从中取出利润最大的
            while (!capPq.isEmpty() && capPq.peek()[0] <= W) {
                proPq.offer(capPq.poll());
            }
            if (proPq.isEmpty()) {
                break;
            }
            W += proPq.poll()[1];

        }
        return W;
    }

    class capComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }

    class proComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o2[1] - o1[1];
        }
    }
}
