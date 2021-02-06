package bytedance;

public class NC22 {
    public void merge(int a[], int m, int b[], int n) {
        if (b == null || b.length == 0) {
            return;
        }
        int aIndex = m - 1;
        int bIndex = n - 1;
        int index = m + n - 1;
        while (aIndex >= 0 && bIndex >= 0) {
            if (a[aIndex] <= b[bIndex]) {
                a[index--] = b[bIndex];
                bIndex--;
            } else {
                a[index--] = a[aIndex];
                aIndex--;
            }
        }
        if (bIndex >= 0) {
            for (int i = 0; i <= bIndex; i++) {
                a[i] = b[i];
            }
        }
    }
}
