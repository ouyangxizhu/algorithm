package Tencent.First;

public class First_8 {
	public static void main(String[] args) {
		
		System.out.println(isValid("{}()"));
	}
	public static boolean isValid(String s) {
		if (s == null) {
			return true;
		}
		StringBuilder sb = new StringBuilder();
		int j = 0;// 记录指针在sb中的位置
		if (s.length()%2==0) {
			
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch != ' ') {
					if (getValue(ch) < 0) {
						sb.append(ch);
						j++;
					} else {
						if (j>0&&(getValue(sb.charAt(j-1)) + getValue(ch)) == 0) {
							j--;
							sb.deleteCharAt(sb.length()-1);
						} else {
							return false;
						}
					}
					
				}
			}
			if (j==0) {
				
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}

	}
    public static int getValue (char ch ){
    	switch (ch) {
		case '(':
			return -1;
			
		case '[':
			return -2;
			
		case '{':
			return -3;
			
		case ')':
			return 1;
			
		case ']':
			return 2;
			
		case '}':
			return 3;
			

		default:
			return 0;
		}
    }

}
