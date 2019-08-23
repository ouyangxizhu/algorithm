package leetcode.all;

public class Leetcode_1108 {
    public String defangIPaddr1(String address) {
        return address.replaceAll("\\.", "[\\.]");
    }
    public String defangIPaddr(String address) {
        StringBuilder s = new StringBuilder();
        char[] chars = address.toCharArray();
        char ch = chars[0];
        for (int i = 0; i < address.length(); i++) {
            ch = chars[i];
            if (ch == '.') {
                s.append('[');
                s.append('.');
                s.append(']');
            } else {
                s.append(ch);
            }
        }
        return s.toString();
    }
    public String defangIPaddr2(String address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                s.append('[');
                s.append('.');
                s.append(']');
            } else {
                s.append(address.charAt(i));
            }
        }
        return s.toString();

    }
}
