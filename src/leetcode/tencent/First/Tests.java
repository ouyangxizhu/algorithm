package Tencent.First;

public class Tests {
	public static void main(String[] args) {
		char [] ch = {'1','2','4','3','7','6','2'};
		String string = new String(ch);
		int inch = ch[2];
		System.out.println(string);
		System.out.println(inch);
		System.out.println(multiply("123", "456"));
		
	}
	public static String multiply(String num1, String num2) {
		if (num1 == "0" || num2 == "0")
	        return "0";
		char[] char1 = num1.toCharArray();
		char[] char2 = num2.toCharArray();
		
	    char[] ch = new char[num1.length()+num2.length()];
	    for (int i = 0; i < ch.length; i++) {
			ch[i]='0';
		}
	    
 	    for (int i = num2.length() - 1; i >= 0; --i) {
	        int mulflag = 0;//����λ
	        int addflag = 0;
	        for(int j = num1.length() - 1; j >= 0; --j) {
	            int temp1 = (char2[i]-'0')  * (char1[j]-'0')  + mulflag;//��������˵�ֵ
	            mulflag = temp1 / 10;//��������˺�Ľ���λ
	            temp1 = temp1 % 10;//��������˺�ȥ������λ�����
	            int temp2 = ch[i + j + 1] - '0'+ temp1 + addflag;//addflag��ÿ��λ�õ�����Ӻ�Ľ���λ
	            ch[i + j + 1] = (char) ('0'+temp2 % 10);
	            addflag = temp2 / 10;//addflag��ÿ��λ�õ�����Ӻ�Ľ���λ
	        }
	        ch[i] += mulflag + addflag;
	    }
	
	    String str = new String(ch);
	    for (int i = 0; i < ch.length; i++) {
			if (ch[i]!='0') {
				str = str.substring(i,ch.length);
				return str;
			}
		}
	    return "0";

    }

}
