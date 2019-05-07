package bishi2019.wangyi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Wangyi5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        boolean flag = false;
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
            int mm = sc.nextInt();
            list.add(mm);
        }
        stack.add(list.get(0));
        for (int i = 1; i< list.size(); i ++){
            int cur = list.get(i);
            while (!stack.isEmpty()){
                if (flag){
                    if (list.get(i) > stack.peek()){
                        sum += stack.pop() * cur * stack.peek();
                        if (cur < stack.peek()){
                            flag = true;
                        }else{
                            flag = false;
                        }
                    }
                }else{
                    if (cur < stack.peek()){
                        flag = true;
                    }else{
                        flag = false;
                    }
                }
                stack.add(cur);
            }

        }
        while (!stack.isEmpty()){
            if (stack.size() == 1){
                sum += stack.pop();
            }else if (stack.size() == 2){
                int tmp = stack.pop();
                sum += stack.pop() * tmp;
                sum += tmp;
            }else{
                int temp = stack.pop();
                sum += stack.pop() * temp * stack.peek();
                stack.add(temp);
            }
        }
        System.out.println(sum);
    }
}
