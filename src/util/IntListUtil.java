package util;

import java.util.List;

/**
 * @author czz
 */
public class IntListUtil {
    public static void printList(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + ",");
        }
    }
}
