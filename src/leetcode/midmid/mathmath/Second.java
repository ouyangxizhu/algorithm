package midmid.mathmath;
/**
 * ��������

����һ������ n������ n! ���β�������������

ʾ�� 1:

����: 3 
���: 0 
����: 3! = 6, β����û���㡣 
ʾ�� 2:

����: 5 
���: 1 
����: 5! = 120, β������ 1 ����. 
˵��: ���㷨��ʱ�临�Ӷ�ӦΪ O(log n) ��

�������

Ҫ��ĩβ�ж��ٸ��㣬�����ӦΪx*10k ����ʽ����x*��2k *5k�� 
Ҳ����������ֽ������Ӻ��м���5���У�����1*2*3*4*5=1*2*3*2*2*5��������һ��5�����Խ��Ϊ1��0��
--------------------- 
���ߣ�wangxizzz 
��Դ��CSDN 
ԭ�ģ�https://blog.csdn.net/qq_36387730/article/details/81669845 
��Ȩ����������Ϊ����ԭ�����£�ת���븽�ϲ������ӣ�
 * @author ouyangxizhu
 *
 */
public class Second {
	 public int trailingZeroes(int n) {
	     if (n<5) {
			return 0;
		}
	     int result = 0;
	     while (n!=0) {
			result += n/5;
			n = n/5;
			
		}
	     return result;
	 }

}
