package bytedance;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NC5 {
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers1 (TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = getAllNums(root, 0, new ArrayList<Integer>());
        return list.parallelStream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> getAllNums(TreeNode root, int i, List<Integer> result) {
        int num = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            result.add(num);
        } else {
            if (root.left != null) {
                getAllNums(root.left, num, result);
            }
            if (root.right != null) {
                getAllNums(root.right, num, result);
            }
        }
        return result;
    }
    public int sumNumbers (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSumNumbers(root, 0);
    }

    private int getSumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return getSumNumbers(root.left, sum) + getSumNumbers(root.right, sum);
    }
}
