package primary.otherss;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���Ǹ����� numRows������������ǵ�ǰ numRows �С�
 * ����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�

ʾ��:

����: 5
���:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author ouyangxizhu
 *
 */
public class Fourth {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return triangle;
		}
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		triangle.add(temp);
		for (int i = 1; i < numRows; i++) {
			List<Integer> last = triangle.get(i-1);
			List<Integer> temp1 = new ArrayList<Integer>();
			temp1.add(1);
			for (int j = 1; j < i; j++) {
				temp1.add(last.get(j-1)+last.get(j));
			}
			temp1.add(1);
			triangle.add(temp1);
		}
		return triangle;
		
    }
}
