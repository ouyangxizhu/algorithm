package bytedance;

import apple.laf.JRSUIUtils;
import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NC16 {
    /**
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetric (TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    public boolean isSymmetric1 (TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right != null) {
                return false;
            }
            if (left != null && right == null) {
                return false;
            }
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                q.offer(left.left);
                q.offer(right.right);
                q.offer(left.right);
                q.offer(right.left);
            }
        }
        return true;
    }
}
