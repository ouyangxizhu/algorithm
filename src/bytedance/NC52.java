package bytedance;

import java.util.Stack;

public class NC52 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char ch : chars) {
            int index = getIndex(ch);
            if (index < 0) {
                stack.push(index);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Integer pop = stack.pop();
                if (pop + index != 0) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        boolean flag = true;
        while(flag){
            int len = s.length();
            s=s.replace("()","");
            s=s.replace("[]","");
            s=s.replace("{}","");
            if(len == s.length()){
                flag=false;
            }
        }
        return s.length() == 0;

    }

    public int getIndex(char ch) {
        if ('(' == ch) {
            return -1;
        } else if (')' == ch) {
            return 1;
        } else if ('[' == ch) {
            return -2;
        } else if (']' == ch) {
            return 2;
        } else if ('{' == ch) {
            return -3;
        } else if ('}' == ch) {
            return 3;
        } else {
            return 0;
        }
    }
}
