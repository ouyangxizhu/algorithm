package primary.otherss;
/**
 * ��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��

������������ x �� y����������֮��ĺ������롣

ע�⣺
0 �� x, y < 231.

ʾ��:

����: x = 1, y = 4

���: 2

����:
1   (0 0 0 1)
4   (0 1 0 0)
       ��   ��

����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
 * @author ouyangxizhu
 *
 */
public class Second {
	 public int hammingDistance(int x, int y) {
        int z = x^y;
         int count = 0;
        while(z!=0){
        	count++;
        	z=z&(z-1);
        }
        return count;
    }
}
