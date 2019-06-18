package primary.mathmath;
/**
 * ͳ������С�ڷǸ����� n ��������������

ʾ��:

����: 10
���: 4
����: С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��
 * @author ouyangxizhu
 *
 */
public class Second {
	 public int countPrimes(int n) {
		 if (n<=2) {
			return 0;
		}
		 boolean[] origin = new boolean[n];
		 for (int i = 0; i <= n; i++) {
			origin[i]=true;
		}
		 for (int i = 2; i < n; i++) {
			if (origin[i]) {
				int temp = i+i;
				while (temp < n) {
					origin[temp] = false;
					temp +=i;
				}
			}
		}
		 int result = 0;
		 for (int i = 2; i < n; i++) {
			if (origin[i]) {
				result++;
			}
			
		}
		 return result;
	        
	 }
	 
}
