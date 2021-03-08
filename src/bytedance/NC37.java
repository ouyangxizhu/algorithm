package bytedance;

import util.Interval;

import java.util.ArrayList;

public class NC37 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
//        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        intervals.sort((a, b) -> a.start - b.start);
        ArrayList<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.size()) {
            int left = intervals.get(i).start;
            int right = intervals.get(i).end;
            while (i < intervals.size() - 1 && intervals.get(i + 1).start <= right) {
                right = Math.max(right, intervals.get(i + 1).end);
                i++;
            }
            result.add(new Interval(left, right));
            i++;
        }
        return result;
    }
}
