package midmid.sortsort;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @author ouyangxizhu
 *
 */
public class Six {
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size()<=1) {
			return intervals;
		}
        Collections.sort(intervals, new Comparator<Interval>() {
        	@Override
        	public int compare(Interval o1, Interval o2) {
        		return o1.start-o2.start;
        	}
		});
        Interval ii, jj;
        for (int i = 0; i < intervals.size(); i++) {
            ii = intervals.get(i);
            for (int j = i + 1; j < intervals.size(); j++) {
                jj = intervals.get(j);
                if (ii.end >= jj.start) {
                    ii.end = Math.max(jj.end, ii.end);
                    intervals.remove(j);
                    j--;
                }
            }
        }
        return intervals;

    }
}
