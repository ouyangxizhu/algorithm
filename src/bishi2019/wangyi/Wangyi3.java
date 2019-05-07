package bishi2019.wangyi;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Wangyi3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        boolean[] flag = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int end = n - 1;
        while (start < end){
            for (int i = start; i < end; i++){
                if ((a[i] + a[end] > w) && !flag[i]){
                    stack.add(a[i]);
                    stack.add(a[end]);
                    flag[i] = true;
                    flag[end] = true;
                    start = i + 1;
                    end --;
                    break;
                }else if(i == end - 1){
                    start = end;
                    break;
                }
            }
        }
//        if (a[end] + stack.peek() > w){
//            stack.add(a[end]);
//            flag[end] = true;
//        }
        int sum = 0;
        for (int i = 0; i <= end; i++){
            if (!flag[i]){
                sum ++;
            }
        }

        System.out.println(stack.size() + (sum + 1)/2);
    }
}
