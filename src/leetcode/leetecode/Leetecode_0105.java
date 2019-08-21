package leetcode.leetecode;

import util.TreeNode;

import java.util.Random;

public class Leetecode_0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reConstructTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode reConstructTreeNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                root.left = reConstructTreeNode(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
                root.right = reConstructTreeNode(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

}
