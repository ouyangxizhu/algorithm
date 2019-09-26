package qiuzhao2019.aiqiyi;
import java.util.ArrayList;
import java.util.Scanner;

public class Aiqiyi1 {
    static long res = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n - 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        boolean[] vi = new boolean[n + 1];
        helper(vi, a, n);
        System.out.println(res % 1000000007);
    }

    private static void helper(boolean[] vi, int[] a, int n) {

        if (!vali(list, a)) {
            return;
        }
        if (list.size() == n) {
            res++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (vi[i]) {
                continue;
            }
            vi[i] = true;
            list.add(i);
            helper(vi, a, n);
            vi[i] = false;
            list.remove(list.size() - 1);
        }

    }

    private static boolean vali(ArrayList<Integer> list, int[] a) {
        if (list.size() == 0)
            return true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (a[i] == 0) {
                if (list.get(i) >= list.get(i + 1)) {
                    return false;
                }
            }
            if (a[i] == 1) {
                if (list.get(i) <= list.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

}
