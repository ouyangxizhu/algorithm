package bytedance;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Stack;

public class NC90 {
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack (int[][] op) {
        GetMinStack getMinStack = new GetMinStack();
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] arr : op) {
            if (arr[0] == 1) {
                getMinStack.push(arr[1]);
            } else if (arr[0] == 2) {
                getMinStack.pop();
            } else {
                list.add(getMinStack.getMin());
            }
        }
        return list.parallelStream().mapToInt(Integer::intValue).toArray();
    }

    class GetMinStack {
        private Stack<Integer> pushStack = new Stack<Integer>();
        private Stack<Integer> minStack = new Stack<Integer>();

        public void push(int num) {
            pushStack.add(num);
            if (minStack.isEmpty()) {
                minStack.push(num);
            } else if (num <= minStack.peek()) {
                minStack.push(num);
            }
        }

        public int pop() {
            if (pushStack.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            int pop = pushStack.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
            }
            return pop;
        }

        public Integer getMin() {
            return minStack.peek();
        }
    }
}
