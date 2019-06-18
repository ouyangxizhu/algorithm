package tencentfive;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author ouyangxizhu
 *
 */
public class First {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		generateOneByOne("", list, n, n);
		return list;
	}

	public void generateOneByOne(String sublist, List<String> list, int left, int right) {
		if (left > right) {
			return;
		}

		if (left > 0) {
			generateOneByOne(sublist + "(", list, left - 1, right);
		}

		if (right > 0) {
			generateOneByOne(sublist + ")", list, left, right - 1);
		}

		if (left == 0 && right == 0) {
			list.add(sublist);
			return;
		}
	}
	public static void main(String[] args) {
		System.out.println(new First().generateParenthesis(3));
	}

}
