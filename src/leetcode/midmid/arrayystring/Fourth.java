package midmid.arrayystring;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 无重复字符的最长子串是 "b"，其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 * @author ouyangxizhu
 *
 */
public class Fourth {
	/**
	 * 分析

很明显的就能看出来这是一个模式串匹配的题。在这个题里面，主串是已匹配过的子字符串，而字串是一个字符。然后一直滑动到最后。 
那么明白思路就好说了，

暴力破解 
暴破的话就是双层循环，将所有字串都遍历一遍，现在匹配得子字符串就是一个窗口，当我们遇到重复的字符时，我们会将我们的窗口往后移一位。当窗口位置位于 [i，j)时，在j这个位置上匹配到了重复字符，我们会将i+1，新窗口为[i+1，i+1+1)，匹配的字符为i+1+1，

首先双层循环，i从0~n-1，j从i+1~n从这两层循环里得到所有的字串。
使用java的indexOf方法判断，已匹配的字符串中是否包含该字符。
滑动窗口 
既然是模式串匹配，那么肯定是要有优化的滑动窗口的。 
在匹配中我们遇到重复字符，不能i+1，比如目前窗口是[i，j)，在j位匹配到重复字符，我们已经知道在在[i，j-1]窗口内是没有重复字符的，而在j位就存在了重复字符，
重复的位置在s位，那么我们再去匹配[i+1，i+1+1]到[i+1，j]是没有意义的，因为一定会有重复字符，而且长度会小于之前的长度。
所以我们直接将窗口滑到匹配到的重复字符s的位置。即新窗口为[s+1，s+1)；

暴破的代码就不上了，上滑动窗口代码

	 */
	 public int lengthOfLongestSubstring(String s) {
		 int sLen = s.length(),matchLen = 0;
		 Map<Character, Integer> map = new HashMap<Character, Integer>();
		 for (int i = 0, j = 0; j < sLen; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(i, map.get(s.charAt(j)));
			}
			matchLen = Math.max(matchLen, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		 return matchLen;
	        
	 }
	

}
