package Tencent.First;
/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
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
        
        int li = 0, lj = 0, ri = matrix.length-1, rj = matrix[0].length-1;//分别是左上角和右下角的坐标，控制所打印的环。
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
