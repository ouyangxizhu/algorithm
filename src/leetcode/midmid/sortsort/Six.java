package midmid.sortsort;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * �ϲ�����
����һ������ļ��ϣ���ϲ������ص������䡣

ʾ�� 1:

����: [[1,3],[2,6],[8,10],[15,18]]
���: [[1,6],[8,10],[15,18]]
����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
ʾ�� 2:

����: [[1,4],[4,5]]
���: [[1,5]]
����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
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
