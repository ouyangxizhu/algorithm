package Tencent.Third;
/**
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������

ʾ�� 1:

����: 121
���: true
ʾ�� 2:

����: -121
���: false
����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
ʾ�� 3:

����: 10
���: false
����: ���������, Ϊ 01 �����������һ����������
����:

���ܲ�������תΪ�ַ�����������������
 * @author ouyangxizhu
 *
 */
public class Third_2 {
	 public boolean isPalindrome(int x) {
	    if (x<0) {
	    	return false;
	    }
		int d=1;
		while (x/d>=10) {
			d=d*10;
		}
		while (x>0) {
			int q= x/d;//���λ
			int r = x%10;//���λ��
			if (q!=r) {
				return false;
			}
			x=x%d;
			x=x/10;
			d/=100;
		}
		
	    return true;
	 }
	
	 

}
