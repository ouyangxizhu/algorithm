package Tencent.First;
/**
 * ����һ�������� n������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���

ʾ��:

����: 3
���:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
import java.util.ArrayList;
import java.util.List;

public class First_17 {
	public int[][] generateMatrix(int n) {
		int [][]matrix = new int[n][n];
        
        int li = 0, lj = 0, ri = matrix.length-1, rj = matrix[0].length-1;//�ֱ������ϽǺ����½ǵ����꣬��������ӡ�Ļ���
        int m = 1;
        while(li <= ri && lj <= rj) {
            int i = li, j = lj;
            while(j <= rj) {
                matrix[i][j]=m++;
                j++;
                
            }
            --j;++i;
            while(i <= ri) {
            	matrix[i][j]=m++;
                i++;
            }
            --i;--j;
            while(j > lj && li != ri) {
            	matrix[i][j]=m++;
                j--;
            }
            while(i > li && lj != rj) {
            	matrix[i][j]=m++;
                i--;
            }
            li++;lj++;ri--;rj--;
        }
        return matrix;
    }

}
