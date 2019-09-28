package leetcode.all;


import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_0435 {
    /**
     * https://leetcode-cn.com/problems/non-overlapping-intervals/solution/wu-zhong-die-qu-jian-by-leetcode/
     * 方法二：从起始点的动态规划 【通过】
     * 算法
     *
     * 如果我们按照起始点对区间进行排序，可以很大程度上简化问题。
     * 一旦完成之后，我们就可以使用一个 dp 数组，其中 dp[i] 存储着只考虑到 第i个 区间范围内（包括其本身），
     * 最大可能的区间数。现在，当计算 dp[i+1]时，我们不能只考虑 dp[i] 的值，
     * 因为前面的 ii个区间都可能与 第 i+1i+1 个区间发生重叠。
     * 因此，我们需要考虑能够使得 j≤i 且与第 i+1个区间不发生重叠的所有 dp[j]dp[j] 中的最大值。状态转移方程如下：
     *
     * dp[i+1]=max(dp[j])+1,
     *
     * 其中对于所有 j≤i ，第 i 个和第 j 个区间不发生重叠。
     *
     * 最后，为了计算最终列表中区间的最大区间数量，我们需要找到 dp数组中的最大值。最终的结果为区间的总数减去刚刚的结果 (intervalsArrays.length-ansintervals.length−ans)。
     *
     *     复杂度分析
     *
     *      时间复杂度 : O(n^2)。需要两重循环。
     *
     *      空间复杂度 : O(n)。 dp 数组占用的空间。
     * @param intervalsArrays
     * @return
     */
    public int eraseOverlapIntervals1(int[][] intervalsArrays) {
        if (intervalsArrays == null || intervalsArrays.length == 0 || intervalsArrays.length == 1) {
            return 0;
        }
        Interval[] intervals = new Interval[intervalsArrays.length];
        for (int i = 0; i < intervalsArrays.length; i++) {
            intervals[i] = new Interval(intervalsArrays[i]);
        }
        Arrays.sort(intervals, Comparator.comparing(o -> o.start));
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!isOverLapping(intervals[j], intervals[i])) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return intervals.length - ans;

    }

    /**
     * 方法三：从终点的动态规划 【通过】
     * 算法
     *
     * 在上面讨论过的 DP 算法中，为了计算每个 dp[i]的值，我们需要遍历 dp数组，直到起始索引.
     * 如果我们使用根据终点排序的列表，则可以去除这一开销。
     * 我们依然使用 dp 数组，其中 dp[i]用于存储存储着只考虑到 第i个区间范围内（包括其本身），最大可能的区间数。
     * 为了计算 dp[i+1]，考虑两种情况:
     *
     * 情况一
     *
     * 第 i+1个区间对应的区间需要被包括在最终列表中以达到删除区间最少:
     *
     * 在这种情况下，我们需要从第 i + 1到开头遍历区间数组，寻找第一个不重叠的区间。
     * 这是由于，如果我们要包含当前区间，我们就需要移除所有和当前区间重叠的区间。
     * 但我们不需要每次都回到开头，相反，我们可以在找到第一个不重叠的区间后停止遍历，
     * 并用 dp[j] + 1填入 dp[i+1] ，因为 dp[j]d 是存储 直到第 jj个区间范围内最大区间数的元素。
     *
     * 情况二
     *
     * 第 i+1个区间对应的区间需要被移除以达到删除区间最少：
     *
     * 在这种情况下，当前元素不会被包括在最终列表中。因此，考虑到第 i+1个区间的最大数量和 只考虑到 i个的相同。
     * 因此，我们用 dp[i]的值填充 dp[i+1]。
     *
     * 最终 dp[i+1]的值为上述两值中较大的。
     *
     * 最终的结果为区间的总数减去 dpdp 数组的最大值。下面的动画展示了算法过程：
     *
     复杂度分析

     时间复杂度 : O(n^2)。需要两重循环。

     空间复杂度 : O(n)。 dp 数组占用的空间。
     * @param intervalsArrays
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervalsArrays) {
        if (intervalsArrays == null || intervalsArrays.length == 0 || intervalsArrays.length == 1) {
            return 0;
        }
        Interval[] intervals = new Interval[intervalsArrays.length];
        for (int i = 0; i < intervalsArrays.length; i++) {
            intervals[i] = new Interval(intervalsArrays[i]);
        }
        Arrays.sort(intervals, Comparator.comparing(o -> o.end));
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!isOverLapping(intervals[j], intervals[i])) {
                    max = Math.max(dp[j], max);
                    break;
                }

            }
            dp[i] = Math.max(max + 1, dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return intervals.length - ans;

    }

    /**
     * ####方法四：从起点的贪心算法 【通过】
     *
     * 算法
     *
     * 如果我们按照起点对区间进行排序，贪心算法就可以起到很好的效果。当按照起点先后顺序考虑区间的时候。我们利用一个 prevprev 指针追踪刚刚添加到最终列表中的区间。遍历的时候，可能遇到图中的三种情况：
     *
     情况一

     当前考虑的两个区间不重叠：

     在这种情况下，不移除任何区间，将 prevprev 赋值为后面的区间，移除区间数量不变。

     情况二

     两个区间重叠，后一个区间的终点在前一个区间的终点之前。

     这种情况下，我们可以简单地只用后一个区间。这是显然的，因为后一个区间的长度更小，可以留下更多的空间（A和 B），容纳更多的区间。因此， prevprev 更新为当前区间，移除区间的数量 + 1。

     情况三

     两个区间重叠，后一个区间的终点在前一个区间的终点之后。

     这种情况下，我们用贪心策略处理问题，直接移除后一个区间。为了理解这种做法的正确性，请看下图，该图包含了所有可能的情况。从图可以清楚地看出，选择前移区间总会得到更好的结果。因此，prevprev 不变，移除区间的数量 + 1。

     * @return
     */
    public int eraseOverlapIntervals3(int[][] intervalsArrays) {
        if (intervalsArrays == null || intervalsArrays.length == 0 || intervalsArrays.length == 1) {
            return 0;
        }
        Interval[] intervals = new Interval[intervalsArrays.length];
        for (int i = 0; i < intervalsArrays.length; i++) {
            intervals[i] = new Interval(intervalsArrays[i]);
        }
        Arrays.sort(intervals, Comparator.comparing(o -> o.start));
        int end = intervals[0].end, prev = 0, count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (isOverLapping(intervals[prev], intervals[i])) {
                if (intervals[prev].end > intervals[i].end) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }

    /**
     * 方法五：从终点的贪心算法 【通过】
     * 算法
     *
     * 上面讨论的贪心算法是根据起点进行贪心选择。而在本方法中，我们根据终点进行贪心选择。为此，我首先根据终点对区间进行排序。接着，对排好序的区间进行遍历。在遍历的过程中，若没有区间重叠，就不移除任何区间。如果存在重叠，就直接删除掉当前区间。
     *
     * 为了解释这种做法，我们继续对每种可能情况进行讨论。
     *
     * 情况一
     *
     * 当前考虑的两个区间不重叠：
     *
     * 在这种情况下，不移除任何区间，将 prevprev 赋值为后面的区间。
     *
     * Case 2:
     *
     * 两个区间重叠，当前区间的终点在前一个区间的终点之后。
     *
     * 在这种情况下，如图所示，前一个区间是当前区间的真子集。因此，移除当前区间可以给别的区间更多的容纳空间。因此，保留前一个区间不变，更新当前区间。
     * Case 3:
     *
     * 两个区间重叠，当前区间的终点在前一个区间的终点之前。
     *
     * 在这种情况下，出现了唯一有可能移除前一个区间的机会，因为移除前一个区间可以带来 A 的额外空间。然而，类似于上图的 3a 和 3b，此时也不应该移除前一个区间。然而，移除当前区间却可以带来 BB 的额外空间。因此，保留前一个区间不变，更新当前区间。
     *
     * @param intervalsArrays
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervalsArrays) {
        if (intervalsArrays == null || intervalsArrays.length == 0 || intervalsArrays.length == 1) {
            return 0;
        }
        Interval[] intervals = new Interval[intervalsArrays.length];
        for (int i = 0; i < intervalsArrays.length; i++) {
            intervals[i] = new Interval(intervalsArrays[i]);
        }
        Arrays.sort(intervals, Comparator.comparing(o -> o.end));
        int end = intervals[0].end, count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }


    public boolean isOverLapping(Interval i, Interval j) {
        return i.end > j.start;
    }

    class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public Interval(int[] inter) {
            this.start = inter[0];
            this.end = inter[1];
        }
    }
}
