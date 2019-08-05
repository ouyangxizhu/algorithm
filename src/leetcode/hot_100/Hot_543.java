package leetcode.hot_100;

import util.TreeNode;

public class Hot_543 {
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return res;
    }
    private int maxDiameter(TreeNode root){
        if(root == null) return 0;

        int left = maxDiameter(root.left);
        int right = maxDiameter(root.right);

        res = Math.max(res, left + right);
        //返回层数
        return Math.max(left, right) + 1;
    }
}
