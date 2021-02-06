package bytedance;

public class NC68 {
    private int[] a;
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloor1(int target) {
        if (target <= 2) {
            return target;
        }
        int[] a = new int[target + 1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        jump(a, target);
        return a[target];
    }

    private int jump(int[] a, int target) {
        if (a[target] != 0) {
            return a[target];
        } else {
            a[target] = jump(a, target - 1) + jump(a, target - 2);
            return a[target];
        }
    }

    public static void main(String[] args) {
        System.out.println(new NC68().JumpFloor1(3));
    }

}
