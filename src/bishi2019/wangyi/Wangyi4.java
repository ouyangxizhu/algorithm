package bishi2019.wangyi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Wangyi4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        boolean flag = false;
        String[] split = sc.nextLine().split(" ");

        stack.add(Integer.valueOf(split[0]));
        for (int i = 1; i< split.length; i ++){
            int cur = Integer.valueOf(split[i]);
            if (!stack.isEmpty()){
                if (flag){
                    if (cur > stack.peek()){
                        sum += stack.pop() * cur * stack.peek();
                    }
                }
                if (cur < stack.peek()){
                    flag = true;
                }else{
                    flag = false;
                }
                stack.add(cur);
            }
        }
        while (!stack.isEmpty()){
            if (stack.size() == 1){
                sum += stack.pop();
            }else if (stack.size() == 2){
                int tmp = stack.pop();
                int tmp1 = stack.pop();
                sum +=  tmp1 * tmp;
                sum += tmp > tmp1? tmp : tmp1;
            }else{
                int temp = stack.pop();
                sum += stack.pop() * temp * stack.peek();
                stack.add(temp);
            }
        }
        System.out.println(sum);
    }
}
