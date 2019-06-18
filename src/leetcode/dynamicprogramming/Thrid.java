package dynamicprogramming;
/*
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�

��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������

ע���㲻���������Ʊǰ������Ʊ��

ʾ�� 1:

����: [7,1,5,3,6,4]
���: 5
����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
     ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
ʾ�� 2:

����: [7,6,4,3,1]
���: 0
����: �����������, û�н������, �����������Ϊ 0��
 */
public class Thrid {
	 public int maxProfit(int[] prices) {
        if (prices.length==1) {
			return 0;
		}
		int max = 0;
		int sum = 0;
		for (int i = 1; i < prices.length; i++) {
			sum+= prices[i]-prices[i-1];
			max = Math.max(max, sum);
			sum=Math.max(0, sum);
		}
		return max; 
    }
}
