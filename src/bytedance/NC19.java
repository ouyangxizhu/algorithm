package bytedance;

public class NC19 {

    public int maxsumofSubarray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = sum > 0 ? sum + arr[i] : arr[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(new NC19().maxsumofSubarray(a));
    }
}
