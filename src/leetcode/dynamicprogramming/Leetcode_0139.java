package leetcode.dynamicprogramming;

import java.util.*;

public class Leetcode_0139 {
    public boolean wordBreak1(String s, List<String> wordDict) {
        return helper1(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    /**
     * 方法 3：使用宽度优先搜索
     *
     * 算法
     *
     * 另一个方法是使用宽度优先搜索。将字符串可视化成一棵树，每一个节点是用 endend 为结尾的前缀字符串。当两个节点之间的所有节点都对应了字典中一个有效字符串时，两个节点可以被连接。
     *
     * 为了形成这样的一棵树，我们从给定字符串的第一个字符开始（比方说 ss ），将它作为树的根部，开始找所有可行的以该字符为首字符的可行子串。进一步的，将每一个子字符串的结束字符的下标（比方说 ii）放在队列的尾部供宽搜后续使用。
     *
     * 每次我们从队列最前面弹出一个元素，并考虑字符串 s(i+1,end)s(i+1,end) 作为原始字符串，并将当前节点作为树的根。这个过程会一直重复，直到队列中没有元素。如果字符串最后的元素可以作为树的一个节点，这意味着初始字符串可以被拆分成多个给定字典中的子字符串。

     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    /**
     * 方法 4：使用动态规划
     *
     * 算法
     *
     * 这个方法的想法是对于给定的字符串（ss）可以被拆分成子问题 s1s1 和 s2s2 。如果这些子问题都可以独立地被拆分成符合要求的子问题，那么整个问题 ss 也可以满足。也就是，如果 "\text{catsanddog}catsanddog" 可以拆分成两个子字符串 "\text{catsand}catsand" 和 "\text{dog}dog" 。子问题 "\text{catsand}catsand" 可以进一步拆分成 "\text{cats}cats" 和 "\text{and}and" ，这两个独立的部分都是字典的一部分，所以 "\text{catsand}catsand" 满足题意条件，再往前， "\text{catsand}catsand" 和 "\text{dog}dog" 也分别满足条件，所以整个字符串 "\text{catsanddog}catsanddog" 也满足条件。
     *
     * 现在，我们考虑 \text{dp}dp 数组求解的过程。我们使用 n+1n+1 大小数组的 \text{dp}dp ，其中 nn 是给定字符串的长度。我们也使用 2 个下标指针 ii 和 jj ，其中 ii 是当前字符串从头开始的子字符串（s's
     * ′
     *  ）的长度， jj 是当前子字符串（s's
     * ′
     *  ）的拆分位置，拆分成 s'(0,j)s
     * ′
     *  (0,j) 和 s'(j+1,i)s
     * ′
     *  (j+1,i) 。
     *
     * 为了求出 \text{dp}dp 数组，我们初始化 \text{dp}[0]dp[0] 为 \text{true}true ，这是因为空字符串总是字典的一部分。 \text{dp}dp 数组剩余的元素都初始化为 \text{false}false 。
     *
     * 我们用下标 ii 来考虑所有从当前字符串开始的可能的子字符串。对于每一个子字符串，我们通过下标 jj 将它拆分成 s1's1
     * ′
     *   和 s2's2
     * ′
     *   （注意 ii 现在指向 s2's2
     * ′
     *   的结尾）。为了将 \text{dp}[i]dp[i] 数组求出来，我们依次检查每个 \text{dp}[j]dp[j] 是否为 \text{true}true ，也就是子字符串 s1's1
     * ′
     *   是否满足题目要求。如果满足，我们接下来检查 s2's2
     * ′
     *   是否在字典中。如果包含，我们接下来检查 s2's2
     * ′
     *   是否在字典中，如果两个字符串都满足要求，我们让 \text{dp}[i]dp[i] 为 \text{true}true ，否则令其为 \text{false}false 。

     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /**
     方法 2：记忆化回溯

     算法

     在先前的方法中，我们看到许多函数调用都是冗余的，也就是我们会对相同的字符串调用多次回溯函数。为了避免这种情况，我们可以使用记忆化的方法，其中一个 memomemo 数组会被用来保存子问题的结果。每当访问到已经访问过的后缀串，直接用 memomemo 数组中的值返回而不需要继续调用函数。

     通过记忆化，许多冗余的子问题可以极大被优化，回溯树得到了剪枝，因此极大减小了时间复杂度。

     *
     * @param s
     * @param wordDict
     * @param start
     * @param memo
     * @return
     */
    private boolean helper1(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start >= s.length()){
            return true;
        }

        if (memo[start] != null)
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && helper1(s, wordDict, end, memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }

    /**
     * 方法 1：暴力
     *
     * 算法
     *
     * 最简单的实现方法是用递归和回溯。为了找到解，我们可以检查字典单词中每一个单词的可能前缀，如果在字典中出现过，那么去掉这个前缀后剩余部分回归调用。同时，如果某次函数调用中发现整个字符串都已经被拆分且在字典中出现过了，函数就返回 true 。

     * @param s
     * @param wordDict
     * @param start
     * @return
     */
    private boolean helper(String s, Set<String> wordDict, int start) {
        if (start >= s.length()){
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && helper(s, wordDict, end))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Leetcode_0139().wordBreak("leetcode", Arrays.asList("leet","code")));
    }

}
