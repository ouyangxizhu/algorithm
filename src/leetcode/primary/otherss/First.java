package primary.otherss;
/**
 * ��дһ��������������һ���޷�������������������Ʊ��ʽ������λ��Ϊ ��1�� �ĸ�����Ҳ����Ϊ������������

ʾ�� :

����: 11
���: 3
����: ���� 11 �Ķ����Ʊ�ʾΪ 00000000000000000000000000001011
 

ʾ�� 2:

����: 128
���: 1
����: ���� 128 �Ķ����Ʊ�ʾΪ 00000000000000000000000010000000
 * @author ouyangxizhu
 *
 */
public class First {
	 // you need to treat n as an unsigned value
	/**
	 * https://blog.csdn.net/qq_34691713/article/details/80343773
	 * @param n
	 * @return
	 */
    public int hammingWeight(int n) {
        String bs = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < bs.length(); i++) {
			if (bs.charAt(i)=='1') {
				count++;
			}
		}
        return count;
    }
    /**
     * https://blog.csdn.net/RBreeze/article/details/81349019
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int flag = 1;
        int count = 0;
        while(flag!=0){
        	if ((flag&n)!=0) {
				count++;
			}
        	flag=flag<<1;
        }
        return count;
    }
    /**
     * https://blog.csdn.net/RBreeze/article/details/81349019
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while(n!=0){
        	count++;
        	n=n&(n-1);
        }
        return count;
    }
    /**
     * https://blog.csdn.net/yu849893679/article/details/81485304
     * ��ʱ
     */
    public int hammingWeight3(int n) {
        int count = 0;
        while(n!=0){
        	if (n%2==1) {
				
        		count++;
			}
        	n=n>>1;
        }
        return count;
    }
}
