package bytedance;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czz
 */
public class NC93 {
    private Map<Integer, Node> map;
    private Node head = new Node(-1, -1);
    private Node tail= new Node(-1, -1);
    private int LruSize;

    /**
     * lru design
     * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=117&tqId=36039&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        map = new HashMap<>(k);
        LruSize = k;
        head.next = tail;
        tail.pre = head;

        int count = (int)Arrays.stream(operators).filter(arr -> arr[0] == 2).count();
        int[] result = new int[count];
        for (int i = 0, resultIndex = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                result[resultIndex++] = get(operators[i][1]);
            }
        }
        return result;
    }

    private int get(int key) {
        Node node = map.get(key);
        if (null != node) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    private void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
        } else {
            if (map.size() == LruSize) {
                removeTail();
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        moveToHead(node);
    }

    private void moveToHead(Node node) {
        if (null != node.pre && null != node.next) {
            Node nodePre = node.pre;
            Node nodeNext = node.next;
            nodePre.next = nodeNext;
            nodeNext.pre = nodePre;
        }

        Node headNext = head.next;
        head.next = node;
        node.pre = head;

        node.next = headNext;
        headNext.pre = node;
    }

    private void removeTail() {
        Node node = tail.pre;
        Node nodePre = node.pre;
        if (nodePre != null) {
            tail.pre = nodePre;
            nodePre.next = tail;
        }
        map.remove(node.key);
    }

    static class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
