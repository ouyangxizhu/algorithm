package bytedance;

import java.util.Arrays;

/**
 * @author czz
 */
public class NC88 {
    public int findKth(int[] a, int n, int k) {
        quickSort(a, 0, a.length - 1, n - k);
        return a[n - k];
    }

    private void quickSort(int[] a, int left, int right, int k) {
        if (a == null || a.length == 0 || left < 0 || right >= a.length || right - left < 1) {
            return;
        }
        int bigIndex = partition(a, left, right);
        if (bigIndex == k) {
            return;
        } else if (bigIndex < k) {
            quickSort(a, bigIndex + 1, right, k);
        } else {
            quickSort(a, left, bigIndex - 1, k);
        }
    }

    private int partition(int[] a, int left, int right) {
        int pivot = left + ((right - left) >>> 1);
        swap(a, pivot, right);
        int result = left - 1;
        for (int i = left; i < right; i++) {
            if (a[i] < a[right]) {
                swap(a, ++result, i);
            }
        }
        swap(a, ++result, right);
        return result;
    }

    public static void swap(int[] a, int left, int right) {
        if (left == right) {
            return;
        }
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        System.out.println(new NC88().findKth(a, 49, 24));
        Arrays.sort(a);
        System.out.println(a[49-24]);
    }

}
