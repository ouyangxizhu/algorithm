package Tencent.Third;
/**
 * ����һ����������дһ���������ж����Ƿ��� 2 ���ݴη���

ʾ�� 1:

����: 1
���: true
����: 20 = 1
ʾ�� 2:

����: 16
���: true
����: 24 = 16
ʾ�� 3:

����: 218
���: false
 * @author ouyangxizhu
 *
 */
public class Thrid_5 {
	 public boolean isPowerOfTwo(int n) {
		if (n>0){
            return (n & (n-1)) == 0 ;
        }else{
            return false;
        }
	 }
}
