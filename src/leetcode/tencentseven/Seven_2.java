package tencentseven;

import java.util.ArrayList;
import java.util.List;

/*
 * ���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��

push(x) -- ��Ԫ�� x ����ջ�С�
pop() -- ɾ��ջ����Ԫ�ء�
top() -- ��ȡջ��Ԫ�ء�
getMin() -- ����ջ�е���СԪ�ء�
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
