package bytedance;

import util.TreeNode;

import java.util.ArrayList;

public class NC45 {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preSort(list, root);
        int[][] result = new int[3][list.size()];
        copy(result, 0, list);
        list = new ArrayList<>();
        midSort(list, root);
        copy(result, 1, list);
        list = new ArrayList<>();
        lastSort(list, root);
        copy(result, 2, list);
        return result;
    }

    private void lastSort(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        lastSort(list, root.left);
        lastSort(list, root.right);
        list.add(root.val);
    }

    private void midSort(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        midSort(list, root.left);
        list.add(root.val);
        midSort(list, root.right);
    }

    private void copy(int[][] result, int index, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            result[index][i] =list.get(i);
        }
    }

    private void preSort(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preSort(list, root.left);
        preSort(list, root.right);
    }
}
