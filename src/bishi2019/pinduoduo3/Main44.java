package bishi2019.pinduoduo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main44 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = n; i >= n/2; i--) {
            for (int j = m; j >= m/2; j--) {
                int tmp = i * j;
                if (q.size() < k) {
                    q.add(tmp);
                } else {
                    if (tmp > q.peek()) {
                        q.poll();
                        q.add(tmp);
                    }
                }
            }
        }
        System.out.println(q.peek());
    }


}
