package util;

/**
 * @author czz
 */
public class IntArrUtil {
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void swap(int[] a, int left, int right) {
        if (left == right) {
            return;
        }
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }
}
