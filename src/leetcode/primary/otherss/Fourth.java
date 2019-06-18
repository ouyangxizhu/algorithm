package primary.otherss;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
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
