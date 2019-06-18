package primary.arrayy;
/**
 * ����һ�� n �� n �Ķ�ά�����ʾһ��ͼ��

��ͼ��˳ʱ����ת 90 �ȡ�

˵����

�������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��

ʾ�� 1:

���� matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

ԭ����ת�������ʹ���Ϊ:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
ʾ�� 2:

���� matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

ԭ����ת�������ʹ���Ϊ:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 * @author ouyangxizhu
 *
 */
public class Eleven {
	public void rotate(int[][] matrix) {
		int n = matrix.length-1;
		//�����½ǵ����Ͻǵ�б��Ϊ�Գ���
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n-i; j++) {
				int temp = matrix[i][j];
				matrix[i][j]=matrix[n-j][n-i];
				matrix[n-j][n-i]=temp;
			}
			
		}
        //��һ�������һ�л����ڶ����뵹���ڶ��л�����������
        for (int i = 0; i < matrix.length/2; i++) {
        	for (int j = 0; j < matrix.length; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j]=matrix[n-i][j];
        		matrix[n-i][j]=temp;	
			}
			
		}
    }
}
