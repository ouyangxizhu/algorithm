package primary.mathmath;
/**
 * ����һ��������дһ���������ж����Ƿ��� 3 ���ݴη���

ʾ�� 1:

����: 27
���: true
ʾ�� 2:

����: 0
���: false
ʾ�� 3:

����: 9
���: true
ʾ�� 4:

����: 45
���: false
���ף�
���ܲ�ʹ��ѭ�����ߵݹ�����ɱ�����
 * @author ouyangxizhu
 *
 */
public class Third {
	 public boolean isPowerOfThree(int n) {
		 if (n>0) {
			 if (Math.log10(n)/Math.log10(3)%1==0) {
				return true;
			}
		 }	
		return false;
	 }
}
