package Tencent.First;

import java.util.List;
import java.util.ArrayList;

/**
 * ����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�

ʾ�� 1:

����:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
���: [1,2,3,6,9,8,7,4,5]
ʾ�� 2:

����:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
���: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @author ouyangxizhu
 *
 */
public class First_16 {
	public static void main(String[] args) {
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(spiralOrder(matrix));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) return result;
        int li = 0, lj = 0, ri = matrix.length-1, rj = matrix[0].length-1;//�ֱ������ϽǺ����½ǵ����꣬��������ӡ�Ļ���
        while(li <= ri && lj <= rj) {
            int i = li, j = lj;
            while(j <= rj) {
                result.add(matrix[i][j]);
                j++;
            }
            --j;++i;
            while(i <= ri) {
                result.add(matrix[i][j]);
                i++;
            }
            --i;--j;
            while(j > lj && li != ri) {
                result.add(matrix[i][j]);
                j--;
            }
            while(i > li && lj != rj) {
                result.add(matrix[i][j]);
                i--;
            }
            li++;lj++;ri--;rj--;
        }
        return result;
	}

}
