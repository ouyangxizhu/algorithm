package qiuzhao2019.zhaohang;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ZhaoHang {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int[] res = new int[s1.length()];
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if ('L' == ch) {
                stack.add(i);
            }
        }
        Arrays.fill(res, 1);
        int end = stack.pop();
        while (!stack.isEmpty()) {
            int pre = stack.pop();
            if (end == pre + 1) {
                res[pre - 1] += res[end];
                res[end] = 0;
                end = pre;
            } else {
                res[end - 1] --;
                res[end] --;
                for (int i = pre + 1; i <= end; i++) {
                    if (((end - i) & 1) == 1) {
                        res[end - 1]++;
                    } else {
                        res[end]++;
                    }
                    if (i < end - 1) {
                        res[i] = 0;
                    }
                }
                end = pre;
            }
        }
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[res.length - 1]);
    }
}
