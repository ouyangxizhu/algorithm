package Tencent.First;
/**
 * �����������ַ�����ʽ��ʾ�ķǸ����� num1 �� num2������ num1 �� num2 �ĳ˻������ǵĳ˻�Ҳ��ʾΪ�ַ�����ʽ��

ʾ�� 1:

����: num1 = "2", num2 = "3"
���: "6"
ʾ�� 2:

����: num1 = "123", num2 = "456"
���: "56088"
˵����

num1 �� num2 �ĳ���С��110��
num1 �� num2 ֻ�������� 0-9��
num1 �� num2 �������㿪ͷ������������ 0 ����
����ʹ���κα�׼��Ĵ������ͣ����� BigInteger����ֱ�ӽ�����ת��Ϊ����������
 * @author ouyangxizhu
 *
 */
public class First_11 {
	
	public String multiply(String num1, String num2) {
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
