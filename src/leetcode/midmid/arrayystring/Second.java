package midmid.arrayystring;
/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
 *
 */
public class Second {
	public void setZeroes(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		//记录值为0的元素所在行索引和列索引
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix[0].length;j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		//若行i或列j有个元素为0，则将arr[i][j] 置为0
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix[0].length;j++){
				if(row[i]|| column[j]){
					matrix[i][j] =0;
				}
			}
		}

    }
}
