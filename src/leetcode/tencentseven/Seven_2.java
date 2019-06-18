package tencentseven;

import java.util.ArrayList;
import java.util.List;

/*
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
 */
public class Seven_2 {
	List<Integer> list =null;
	
	
    /** initialize your data structure here. */
    public Seven_2() {
    	list = new ArrayList<Integer>();

    }
    
    public void push(int x) {
        list.add(x);
    }
    
    public void pop() {
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        int min = list.get(0);
        for (int i = 0; i <list.size(); i++) {
			if (list.get(i)<min) {
				min = list.get(i);
			}
		}
        return min;
    }
}
