package leetcode.dynamicprogramming;

public class Leetcode_0978 {

    /**
     * 方法：滑动窗口
     *
     *             思路
     *
     *     显然，我们只需要关注相邻两个数字之间的符号就可以了。 如果用 -1, 0, 1 代表比较符的话（分别对应 <、 =、 >），那么我们的目标就是在符号序列中找到一个最长的元素交替子序列 1, -1, 1, -1, ...（从 1 或者 -1 开始都可以）。
     *
     *     这些交替的比较符会形成若干个连续的块 。我们知道何时一个块会结束：当已经到符号序列末尾的时候或者当序列元素不再交替的时候。
     *
     *     举一个例子，假设给定数组为 A = [9,4,2,10,7,8,8,1,9]。那么符号序列就是 [1,1,-1,1,-1,0,-1,1]。它可以被划分成的块为 [1], [1,-1,1,-1], [0], [-1,1]。
     * @param
     * @return
     */
    public int maxTurbulenceSize(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = 1;
        int start = 0;
        for (int i = 1; i < array.length; i++) {
            int c = Integer.compare(array[i], array[i - 1]);
            if (i < array.length - 1 && c * Integer.compare(array[i + 1], array[i]) == -1){
                continue;
            }else{
                if (c != 0)
                    res = Math.max(res, i - start + 1);
                start = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_0978().maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
    }
}
