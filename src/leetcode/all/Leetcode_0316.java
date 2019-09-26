package leetcode.all;

import java.util.Stack;

public class Leetcode_0316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (stack.contains(ch)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && s.lastIndexOf(stack.peek()) > i) {
                stack.pop();
            }
            stack.add(ch);
        }
        StringBuilder res = new StringBuilder();
        for (char c : stack) {
            res.append(c);
        }
        return res.toString();

    }

}
