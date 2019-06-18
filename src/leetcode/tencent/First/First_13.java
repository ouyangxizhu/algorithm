package Tencent.First;

import java.nio.channels.NonReadableChannelException;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @author ouyangxizhu
 *
 */
public class First_13 {
	public String reverseWords(String s) {
		boolean bo= false;
		int start1 = 0;
		int start2 =0;
		int end1 = s.length()-1;
		
		char [] strings = s.toCharArray();
		for (int i = 0; i < strings.length; i++) {
			if (strings[i]==' ') {
				start2 = i+1;
				end1 = i-1;	
				
				while (start1<=end1) {
					char ch = strings[start1];
					strings[start1]= strings[end1];
					strings[end1] = ch;
					start1++;
					end1--;
				}
				start1=start2;
			}
			if (i==s.length()-1) {
				
				end1 = i;	
				
				while (start1<=end1) {
					char ch = strings[start1];
					strings[start1]= strings[end1];
					strings[end1] = ch;
					start1++;
					end1--;
				}
				
			}
			
		}
		return new String(strings);
	        
	}

}
