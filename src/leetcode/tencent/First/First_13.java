package Tencent.First;

import java.nio.channels.NonReadableChannelException;

/**
 * ����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��

ʾ�� 1:

����: "Let's take LeetCode contest"
���: "s'teL ekat edoCteeL tsetnoc" 
ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�
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
