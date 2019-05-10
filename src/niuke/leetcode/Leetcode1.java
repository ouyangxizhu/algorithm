package niuke.leetcode;

import com.sun.glass.ui.Size;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Created by ouyangxizhu on 2019/3/25.
 */
public class Leetcode1 {
    /**
     * 递归
     * 若为空树返回0；
     若左子树为空，则返回右子树的最小深度+1；（加1是因为要加上根这一层，下同）
     若右子树为空，则返回左子树的最小深度+1；
     若左右子树均不为空，则取左、右子树最小深度的较小值，+1；
     */
//    public int run(TreeNode root) {
//        if(root == null) return 0;
//        if(root.left == null)
//            return run(root.right) + 1;
//        if(root.right == null)
//            return run(root.left) + 1;
//        int leftDepth = run(root.left) + 1;
//        int rightDepth = run(root.right) + 1;
//        return leftDepth < rightDepth ? leftDepth : rightDepth;
//    }
    //非递归  思路是层序遍历，找到第一个左右结点都为null的情况，就返回
    public int run(TreeNode root) {
        if (root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int len = q.size();
            depth++;
            for (int i = 0; i < len; i++){
                TreeNode cur = q.poll();
                if(cur.left == null && cur.right == null) return depth;
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);

            }
        }
        return 0;
    }
}
