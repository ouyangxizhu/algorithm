package midmid.sortsort;
/**
 * ������ά���� II
��дһ����Ч���㷨������ m x n ���� matrix �е�һ��Ŀ��ֵ target���þ�������������ԣ�

ÿ�е�Ԫ�ش������������С�
ÿ�е�Ԫ�ش��ϵ����������С�
ʾ��:

���о��� matrix ���£�

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
���� target = 5������ true��

���� target = 20������ false��
 * @author ouyangxizhu
 *
 */
public class Eight {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null||matrix.length==0){
			return false;
		}
		int row=matrix.length;
		int column=matrix[0].length;
		for(int i=0;i<row;i++){
			for(int j=column-1;j>=0;j--){
				if(matrix[i][j]==target){
					return true;
				}else if(matrix[i][j]>target){
					continue;
				}else{
					break;
				}
			}
		}
		return false;  
        
    }

}
