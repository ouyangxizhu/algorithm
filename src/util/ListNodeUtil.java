package util;

public class ListNodeUtil {
    public static void printListnode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }
}
