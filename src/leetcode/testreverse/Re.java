package testreverse;

import java.awt.datatransfer.StringSelection;
import java.util.Stack;

import primary.linkedlistlist.ReverseList;

/**
 * 随便输出一个字符串
String str ="45abc,+de==fg";
里面含有 abc，de，fg 三个单词
怎么处理能让单词反转，其他顺序不变呢
输出 “45cba,+ed==gf”;
这个处理字符串的方法应该怎么写啊
 * @author ouyangxizhu
 *
 */
public class Re {
	public static String reverse (String str){
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			//如果是字母就放入栈中，用来反转，不是字母就先将栈中所有数据取出，再把该字符加入到最后
			if (str.charAt(i) >= 'a'&& str.charAt(i) <= 'z') {
				stack.push(str.charAt(i));
			}else {
				while (!stack.isEmpty()) {
					Character endCharacter = stack.pop();
					sb.append(endCharacter);
				}
				sb.append(str.charAt(i));
			}
			//最后一个是字母的时候，栈非空，将所有字母取出
			if (i==str.length()-1) {
				while (!stack.isEmpty()) {
					Character endCharacter = stack.pop();
					sb.append(endCharacter);
				}
				
			}
		}
		return sb.toString();
		
	}
	public static void main(String[] args) {
		String str ="45abc,+de==fg";
		System.out.println(reverse(str));
		
	}

}
