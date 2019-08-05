package leetcode.bytebalance;

import java.util.HashMap;

public class Byte_567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        char[] s = s2.toCharArray();
        for(int i = 0; i < s.length; i++){
            char c = s[i];
            if(hashmap.containsKey(c)){
                hashmap.put(c, hashmap.get(c) + 1);
            }else{
                hashmap.put(c, 1);
            }
        }
        s = s1.toCharArray();
        for(int i = 0; i < s.length; i++){
            char c = s[i];
            if((!hashmap.containsKey(c)) || hashmap.get(c) == 0)
                return false;
            hashmap.put(c, hashmap.get(c) - 1);
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Byte_567().checkInclusion("ab", "eidbaooo"));
    }
}
