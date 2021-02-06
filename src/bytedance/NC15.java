package bytedance;

import util.ListNode;
import util.TreeNode;

import java.util.*;

public class NC15 {
    /**
     *https://www.nowcoder.com/practice/04a5560e43e24e9db4595865dc9c63a3?tpId=117&tqId=37723&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if (null != root) {
            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                int index = 0;
                while (index++ < size) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> levelOrder1 (TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(root.val);
        NodeAndList nodeAndList = new NodeAndList(Arrays.asList(root), nums);
        while (nodeAndList.nodes.size() != 0) {
            result.add(nodeAndList.nums);
            nodeAndList = getNextLayerNodes(nodeAndList.nodes);
        }
        return result;
    }

    private NodeAndList getNextLayerNodes(List<TreeNode> list) {
        List<TreeNode> nodes = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for (TreeNode treeNode : list) {
            if (treeNode.left != null) {
                nodes.add(treeNode.left);
                nums.add(treeNode.left.val);
            }
            if (treeNode.right != null) {
                nodes.add(treeNode.right);
                nums.add(treeNode.right.val);
            }
        }

        return new NodeAndList(nodes, nums);
    }

    static class NodeAndList {
        public List<TreeNode> nodes;
        public ArrayList<Integer> nums;

        public NodeAndList(List<TreeNode> nodes, ArrayList<Integer> nums) {
            this.nodes = nodes;
            this.nums = nums;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode.left = treeNode1;
        ArrayList<ArrayList<Integer>> arrayLists = new NC15().levelOrder(treeNode);
        System.out.println(arrayLists);
    }
}
