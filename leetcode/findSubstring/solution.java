package java.leetcode.findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class solution {

    // Substring with Concatenation of All Words
    /*
     * Input: s = "barfoothefoobarman", words = ["foo","bar"]
     * Output: [0,9]
     * Explanation:
     * The substring starting at 0 is "barfoo". It is the concatenation of
     * ["bar","foo"] which is a permutation of words.
     * The substring starting at 9 is "foobar". It is the concatenation of
     * ["foo","bar"] which is a permutation of words.
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String i : words) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int wordsLen = words[0].length();
        int strLen = s.length();
        for (var i = 0; i < wordsLen; i++) {
            Map<String, Integer> map2 = new HashMap<>();
            int left = i, j = i, count = 0;
            while (j + wordsLen <= strLen) {
                String sbuStr1 = s.substring(j, j + wordsLen);
                j += wordsLen;
                if (map.containsKey(sbuStr1)) {
                    map2.put(sbuStr1, map2.getOrDefault(sbuStr1, 0) + 1);
                    count++;
                    while (map2.get(sbuStr1) > map.get(sbuStr1)) {
                        String subStr2 = s.substring(left, left + wordsLen);
                        map2.put(subStr2, map2.get(subStr2) - 1);
                        left += wordsLen;
                        count--;
                    }
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    map2.clear();
                    count = 0;
                    left = j;
                }
            }
        }
        return result;
    }
}
