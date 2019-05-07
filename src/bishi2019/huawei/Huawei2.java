package bishi2019.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * abc3(ss2{r2(m)})
 * Created by ouyangxizhu on 2019/4/10.
 */
public class Huawei2 {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static Stack<Integer> stack3 = new Stack<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                System.out.println(new StringBuilder(count(s, i)).reverse().toString());
                return;
            }

        }
    }
    public static String count(String str, int index){
        for(int i = index; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '(')
                stack1.add(i);
            else if (ch == '[')
                stack2.add(i);
            else if (ch == '{')
                stack3.add(i);
            else if (ch == ')'){
                int in = stack1.pop();
                int num = Integer.valueOf(str.charAt(in - 1) + "");
                String ss = str.substring(in + 1, i);
                String st = str.substring(0, in - 1);
                String end = str.substring(i + 1, str.length());
                for (int j = 0; j < num; j++){
                    st = st + ss;
                }
                st = st + end;
                return count(st, i - 2 - ss.length() + ss.length() * num);
            }else if (ch == ']'){
                int in = stack2.pop();
                int num = Integer.valueOf(str.charAt(in - 1) + "");
                String ss = str.substring(in + 1, i);
                String st = str.substring(0, in - 1);
                String end = str.substring(i + 1, str.length());
                for (int j = 0; j < num; j++){
                    st = st + ss;
                }
                st = st + end;
                return count(st, i - 2 - ss.length() + ss.length() * num);
            }else if (ch == '}'){
                int in = stack3.pop();
                int num = Integer.valueOf(str.charAt(in - 1) + "");
                String ss = str.substring(in + 1, i);
                String st = str.substring(0, in - 1);
                String end = str.substring(i + 1, str.length());
                for (int j = 0; j < num; j++){
                    st = st + ss;
                }
                st = st + end;
                return count(st, i - 2 - ss.length() + ss.length() * num);
            }

        }
        return str;
    }
}
