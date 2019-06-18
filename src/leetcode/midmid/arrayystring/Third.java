package midmid.arrayystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ���շ���
����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

ʾ��:

����: ["eat", "tea", "tan", "ate", "nat", "bat"],
���:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
˵����

���������ΪСд��ĸ��
�����Ǵ������˳��
 * @author ouyangxizhu
 *
 */
public class Third {
	public List<List<String>> groupAnagrams(String[] strs) {
		 if(strs.length==0)
	            return new ArrayList<>();
	        HashMap<String,List<String>> maps = new HashMap<>();
	        for(String s:strs)
	        {
	            char[] c = s.toCharArray();
	            Arrays.sort(c);
	            String key = String.valueOf(c);
	            if(!maps.containsKey(key))
	                maps.put(key,new ArrayList());
	            maps.get(key).add(s);
	        }
	        return new ArrayList(maps.values());
    }

}
