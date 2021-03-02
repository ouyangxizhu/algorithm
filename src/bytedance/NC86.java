package bytedance;

public class NC86 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int nn = mat.length - 1;
        int mm = 0;
        while (mm < mat[0].length && nn > 0) {
            if (mat[nn][mm] == x) {
                return new int[]{nn, mm};
            } else if (mat[nn][mm] > x) {
                nn--;
            } else {
                mm++;
            }
        }
        return new int[]{};
    }
}
