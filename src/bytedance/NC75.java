package bytedance;

public class NC75 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }
        int[] result = new int[2];
        int num = 0;
        for (int i : array) {
            num ^= i;
        }
        int m = 1;
        //不同的数必然某一位为1；
        while ((m & num) == 0) {
            m <<= 1;
        }
        //上一步从小的位置向大的遍历，小的那个数必然与m相与为1；
        for (int i : array) {
            if ((i & m) == m) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }
        if (result[0] > result[1]) {
            int tmp = result[0];
            result[0] = result[1];
            result[1] = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] ints = new NC75().FindNumsAppearOnce(a);
    }
}
