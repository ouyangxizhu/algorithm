package niuke.leetcode;

import java.util.Stack;

/**
 * 题目描述

 Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * Created by ouyangxizhu on 2019/5/10.
 */
public class Leetcode2 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String s : tokens){
            try {
                stack.add(Integer.valueOf(s));
            } catch (Exception e) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(get(a, b, s));
            }
        }
        return stack.pop();

    }

    private int get(int a, int b, String operator) {
        switch (operator){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;

        }
    }
}
