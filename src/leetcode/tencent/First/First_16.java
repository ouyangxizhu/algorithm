package Tencent.First;

import java.util.List;
import java.util.ArrayList;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
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
        int li = 0, lj = 0, ri = matrix.length-1, rj = matrix[0].length-1;//分别是左上角和右下角的坐标，控制所打印的环。
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
