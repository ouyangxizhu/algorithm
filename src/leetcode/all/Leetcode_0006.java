package leetcode.all;

public class Leetcode_0006 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int index = i;
            int count = 1;
            while (index < s.length()) {
                stringBuilder.append(chars[index]);
                index = getPosition(i, index, count, numRows);
                count++;
            }
            res.append(stringBuilder.toString());
        }
        return res.toString();
    }
    public int getPosition(int row, int index, int count, int numRows){
        if (row == 0 || row == numRows - 1) {
            return index + numRows + numRows - 2;
        } else {
            int num = count & 1;
            int po = num == 1 ? -1 : 1;
            return index + 2 * (num * (numRows - 1) + row * po);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_0006().convert("PAYPALISHIRING", 3));
    }
}
