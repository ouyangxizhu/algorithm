package leetcode.all;

public class Leetcode_1154 {
    public int dayOfYear(String date) {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");
        int year = Integer.valueOf(split[0]);
        if ((year % 400 == 0) || (year % 100 != 0 && (year & 3) == 0)) {
            days[1] = 29;
        }
        int res = 0;
        for (int i = 0; i < Integer.valueOf(split[1]) - 1; i++) {
            res += days[i];
        }
        return res + Integer.valueOf(split[2]);
    }
    public static void main(String[] args){
        System.out.println(new Leetcode_1154().dayOfYear("1900-03-25"));

    }
}
