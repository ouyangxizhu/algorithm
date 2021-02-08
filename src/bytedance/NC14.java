package bytedance;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NC14 {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder1(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        boolean isSort = true;
        while (!linkedList.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = linkedList.removeFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    linkedList.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.addLast(treeNode.right);
                }
            }
            ArrayList<Integer> list1 = list;
            if (!isSort) {
                list1 = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    list1.add(list.get(i));
                }
            }
            result.add(list1);
            isSort = !isSort;
        }
        return result;
    }

    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root!=null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();     //存储每一层节点
            for(int i= queue.size();i>0;i--){               //遍历当前层的节点
                TreeNode node = queue.poll();               //弹出队列中的节点

                if((res.size()+1)%2!=0){     //res.size()+1：当前的层数，从1开始
                    tmp.add(node.val);       // 奇数层 -> 尾插
                }else{
                    tmp.add(0,node.val);     // 偶数层 -> 头插
                }

                if(node.left!=null){         //如果左子节点不为空，则将其加入到队列中
                    queue.add(node.left);
                }
                if(node.right!=null){         //如果左子节点不为空，则将其加入到队列中
                    queue.add(node.right);
                }
            }
            res.add(tmp);               //将这一层的节点加入到res中
        }
        return res;
    }
}
