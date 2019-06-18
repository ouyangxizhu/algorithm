package midmid.mathmath;
/**
 * ʵ�� int sqrt(int x) ������

���㲢���� x ��ƽ���������� x �ǷǸ�������

���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��

ʾ�� 1:

����: 4
���: 2
ʾ�� 2:

����: 8
���: 2
˵��: 8 ��ƽ������ 2.82842..., 
     ���ڷ���������������С�����ֽ�����ȥ��
 * @author ouyangxizhu
 *https://blog.csdn.net/gqtcgq/article/details/48392255
 */
public class Five {
	 public int mySqrt(int x) {
		if(x == 0)	return 0;
		int rex = x;
		while (rex*rex >x) {
			rex = (rex+x/rex)/2;
			
		}
		return rex;
	 }
}
