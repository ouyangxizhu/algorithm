package bytedance;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NC136 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] xianxu, int[] zhongxu) {
        TreeNode head = resolve(xianxu, zhongxu);
        return printRight(head);
    }

    private int[] printRight(TreeNode head) {
        if (head == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (i == n - 1) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
        }
        return list.parallelStream().mapToInt(Integer::intValue).toArray();
    }

    private TreeNode resolve(int[] xianxu, int[] zhongxu) {
        if (xianxu == null || xianxu.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(xianxu[0]);
        if (xianxu.length == 1) {
            return head;
        }
        for (int i = 0; i < zhongxu.length; i++) {
            if (xianxu[0] == zhongxu[i]) {
                head.left = resolve(Arrays.copyOfRange(xianxu, 1, i + 1), Arrays.copyOfRange(zhongxu, 0, i));
                head.right = resolve(Arrays.copyOfRange(xianxu, i + 1, xianxu.length), Arrays.copyOfRange(zhongxu, i + 1, zhongxu.length));
                return head;
            }
        }
        return head;
    }
}
