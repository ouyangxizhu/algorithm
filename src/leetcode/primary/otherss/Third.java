package primary.otherss;
/**
 * �ߵ������� 32 λ�޷��������Ķ�����λ��

ʾ��:

����: 43261596
���: 964176192
����: 43261596 �Ķ����Ʊ�ʾ��ʽΪ 00000010100101000001111010011100 ��
     ���� 964176192��������Ʊ�ʾ��ʽΪ 00111001011110000010100101000000 ��
����:
�����ε�������������㽫����Ż�����㷨��
 * @author ouyangxizhu
 *
 */
public class Third {
	 public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
			int temp = n&1;
			n=n>>1;
        	result=(result<<1)|temp;
		}
        return result;

    }
}
