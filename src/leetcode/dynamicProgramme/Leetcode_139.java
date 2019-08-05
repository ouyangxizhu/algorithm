package leetcode.dynamicProgramme;

import java.util.Arrays;
import java.util.List;

public class Leetcode_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            s = s.replaceAll(wordDict.get(i), "");
        }
        return s.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_139().wordBreak("leetcode", Arrays.asList("leet","code")));
    }

}
