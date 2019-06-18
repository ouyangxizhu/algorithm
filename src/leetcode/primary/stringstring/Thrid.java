package primary.stringstring;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��

����:

s = "leetcode"
���� 0.

s = "loveleetcode",
���� 2.
 

ע����������Լٶ����ַ���ֻ����Сд��ĸ��
 * @author ouyangxizhu
 *
 */
public class Thrid {
	 public int firstUniqChar(String s) {
		 Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		 char [] ch  = s.toCharArray();
		 for (int i = 0; i < ch.length; i++) {
			if (!map.containsKey(ch[i])) {
				map.put(ch[i], i);
			}else {
				map.put(ch[i], -1);
			}
		}
		 for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue()!=-1) {
				return entry.getValue();
			}
			
		}
		 return -1;
	        
	 }
}
