package high.arrayarray;

import java.util.HashMap;
import java.util.Map;

/**
 * �����ĸ����������������б� A , B , C , D ,�����ж��ٸ�Ԫ�� (i, j, k, l) ��ʹ�� A[i] + B[j] + C[k] + D[l] = 0��

Ϊ��ʹ����򵥻������е� A, B, C, D ������ͬ�ĳ��� N���� 0 �� N �� 500 �����������ķ�Χ�� -228 �� 228 - 1 ֮�䣬���ս�����ᳬ�� 231 - 1 ��

����:

����:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

���:
2

����:
����Ԫ������:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @author ouyangxizhu
 *
 */
public class Third {
	/**
	 * ��Ȼ����������⣬���ӶȻᵽ��ֲ���O(n^4)����Ȼ�ǲ���Ҫ��ġ�

Ȼ���������£���Ϊ����Ļ������Խ����ӶȽ���O(n^2)��

��������������ӶȻ��������ŵģ���ʵ���벻��������Ż������������һ�£�����������O(n^2)���㷨��

˼·���ǣ�HashMap��ǰ������������ɵ����ּ�����ɵĴ������ٱ������������飬�鿴HashMap���Ƿ���������͵��෴����������ڣ����¼���ִ������ۼӼ�Ϊ�����
--------------------- 
���ߣ�whd_Alive 
��Դ��CSDN 
ԭ�ģ�https://blog.csdn.net/whdAlive/article/details/80459522 
��Ȩ����������Ϊ����ԭ�����£�ת���븽�ϲ������ӣ�
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0)+1);
			}
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				count += map.getOrDefault(-C[i]-D[j], 0);
 			}
		}
        return count;
    }

}
