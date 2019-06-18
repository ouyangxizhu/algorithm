package pinduoduo;

import java.util.Scanner;

public class Main4 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int result = 0;
        int l1 = str1.length();
        int l2 = str2.length();
        if (((l1 + l2) & 1) == 1) {
			System.out.println(0);
			return;
		}if (str1.charAt(0) == ')' && str2.charAt(0) == ')') {
			System.out.println(0);
			return;
		}
        StringBuffer sb = new StringBuffer();
        if (isValid(insertStr(str1, 0, str2, 0, sb))) {
			result++;
		}
        System.out.println(result);
        
    }
	public static String insertStr(String str1, Integer s1, String str2, Integer s2, StringBuffer sb) {
		if (s1 <= str1.length()) {
			sb.append(str1.charAt(s1));
			sb = new StringBuffer(insertStr(str1, s1 + 1, str2, s2, sb));
		}
		if (s2 <= str2.length()) {
			sb.append(str2.charAt(s2));
			sb = new StringBuffer(insertStr(str1, s1, str2, s2 + 1, sb));
		}
		return sb.toString();
		
	}
	public static boolean isValid(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count += charToNum(str.charAt(i));
			if (count > 0) {
				return false;
			}
		}
		return true;
	}
	public static int charToNum(char ch) {
		if (ch == '(') {
			return -1;
		}else {
			return 1;
		}
	}

}
