package tencentseven;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * �����������յ����ݽṹ����ƺ�ʵ��һ��  LRU (�������ʹ��) ������ơ���Ӧ��֧�����²����� ��ȡ���� get �� д������ put ��

��ȡ���� get(key) - �����Կ (key) �����ڻ����У����ȡ��Կ��ֵ�����������������򷵻� -1��
д������ put(key, value) - �����Կ�����ڣ���д��������ֵ�������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ���������ʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣

����:

���Ƿ������ O(1) ʱ�临�Ӷ�����������ֲ�����

ʾ��:

LRUCache cache = new LRUCache( 2 ��������);

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // ����  1
cache.put(3, 3);    // �ò�����ʹ����Կ 2 ����
cache.get(2);       // ���� -1 (δ�ҵ�)
cache.put(4, 4);    // �ò�����ʹ����Կ 1 ����
cache.get(1);       // ���� -1 (δ�ҵ�)
cache.get(3);       // ����  3
cache.get(4);       // ����  4

 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);

 */
public class LRUCache {
	Map<Integer, Integer> map;
	Stack<Integer> stack;
	int size;

	public LRUCache(int capacity) { 
		map = new HashMap<Integer, Integer>(capacity);
		stack = new Stack<Integer>();
		size = capacity;
	
	}

	public int get(int key) {
		if (stack.contains(key)) {
			stack.remove(Integer.valueOf(key));
			stack.push(key);
			return map.get(key);
		}else {
			return -1;
		}
		
	}

	public void put(int key, int value) {
		if (stack.contains(key)) {
			stack.remove(Integer.valueOf(key));
		}else {
			if (stack.size()==size) {
				stack.remove(0);
				map.remove(key);
			}
		}
		stack.push(Integer.valueOf(key));
		map.put(key, value);
	}
	
}
