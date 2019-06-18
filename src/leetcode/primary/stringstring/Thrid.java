package primary.stringstring;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 

注意事项：您可以假定该字符串只包含小写字母。
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
