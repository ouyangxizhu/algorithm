package qiuzhao2019.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tencent3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int res = 0;
        int last = 0;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            list.add(new Node(left, right));
        }
        Collections.sort(list, (o1, o2)-> {
            if (o1.left == o2.left){
                return o2.right - o1.right;
            }else{
                return o1.left - o2.left;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.getRight() <= last ){
                continue;
            }
            if (node.getLeft() > last){
                System.out.println(-1);
                return;
            }
            if (i < list.size() - 1) {
                Node node1 = list.get(i + 1);
                if (node1.getLeft() <= last && node1.getRight() > node.getRight())
                    continue;
            }

            res++;
            last = node.getRight();
            if (last == l) {
                System.out.println(res);
                return;
            }
        }
        System.out.println(res);

    }
    static class Node{
        private int left;
        private int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }
}
