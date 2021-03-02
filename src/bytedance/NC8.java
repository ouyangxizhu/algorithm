package bytedance;

import util.TreeNode;

import java.util.ArrayList;

public class NC8 {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        pathSum(root, sum, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void pathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int cur) {
        if (root == null) {
            return;
        }
        cur += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == cur) {
            result.add(new ArrayList<>(path));
        } else {
            pathSum(root.left, sum, result, path, cur);
            pathSum(root.right, sum, result, path, cur);
        }
        path.remove(path.size() - 1);
    }
}
