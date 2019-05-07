package bishi2019.jingdong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/13.
 */
public class Jingdong1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        HashSet<String> hashSet = new HashSet<>();
        String[] split = sc.nextLine().split(" ");
        hashSet.add(split[0]);
        hashSet.add(split[1]);
        boolean flag = true;
        int left = 1;
        int right = 0;
        while (hashSet.size() != n - 1){
            String[] sp = sc.nextLine().split(" ");
            hashSet.add(sp[0]);
            hashSet.add(sp[1]);
            String str2 = sp[1];
            if ("1".equals(str2)){
                flag = false;
            }
            if (flag){
                left ++;
            }else{
                right++;
            }
        }
        int num = left > right ? left : right;
        System.out.println(num);
    }
    static class Node {
        String str;
        ArrayList<Node> next;

        public Node(String str) {
            this.str = str;
            if (next == null){
                next = new ArrayList<Node>();
            }
        }
        public Node(String[] strs) {
            this.str = strs[1];
            if (this.next != null){
                next.add(new Node(strs[0]));
            }
        }
    }
}
