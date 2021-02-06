package bytedance;

import util.IntArrUtil;

/**
 * https://www.nowcoder.com/practice/2baf799ea0594abd974d37139de27896?tpId=117&tqId=36039&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC140 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * 超时
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public int[] MySort1 (int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (null == arr || arr.length <= 1 || left < 0 || right >= arr.length || left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        if (partition > left) {
            quickSort(arr, left, partition - 1);
        }
        if (partition < right) {
            quickSort(arr, partition + 1, right);
        }

    }

    public int partition(int[] arr, int left, int right) {
        int pivot = (left + right)/2;
        int value = arr[pivot];
        swap(arr, pivot, right);
        int partition = left - 1;
        for (int i = left; i <= right; i++) {
            if (arr[i] <= value) {
                partition++;
                if (i > partition) {
                    swap(arr, partition, i);
                }
            }
        }
        return partition;
    }

    public static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,2,3,1,4};
        IntArrUtil.printArr(new NC140().MySort1(a));
    }
}
