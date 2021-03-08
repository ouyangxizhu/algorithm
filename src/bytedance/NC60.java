package bytedance;

import com.sun.xml.internal.bind.v2.model.core.ID;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NC60 {
    /**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        return new boolean[]{isValidBST(root), isCompleteTree(root)};
    }
    /**
     * 1.递归
     * 2.重载一个函数，界定节点值的范围(lower, upper)
     * 3.递归判断左子树和右子树是否是二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    /**
     * 1.中序遍历二叉树
     * 中序遍历递归和迭代算法
     * 2.判断结果是否是升序
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        ArrayList<Integer> treeNodes = new ArrayList<>();
        midDfs(root, treeNodes);
        for (int i = 0; i < treeNodes.size() - 1; i++) {
            if (treeNodes.get(i) > treeNodes.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    private void midDfs(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        midDfs(root.left, list);
        list.add(root.val);
        midDfs(root.right, list);
    }

    private void midDfs1(TreeNode root, ArrayList<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }

    /**
     * 1.层次遍历直至遇到第一个空节点
     * 2.完全二叉树在遇到空节点之后剩余的应当全是空节点
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }

}
