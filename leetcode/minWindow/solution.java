package java.leetcode.minWindow;

import java.util.HashMap;
import java.util.Map;

public class solution {

    // Minimum Window Substring
    /*
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     */
    public static String minWindow(String s, String t) {
        if (t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int[] minWindow = new int[] { 0, Integer.MAX_VALUE };
        int charRemaining = t.length();
        for (var r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                charRemaining--;
            }
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (charRemaining == 0) {
                while (true) {
                    if (map.containsKey(s.charAt(l)) && map.get(s.charAt(l)) == 0) {
                        break;
                    }
                    map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                    l++;
                }
                if (r - l < minWindow[1] - minWindow[0]) {
                    minWindow = new int[] { l, r };
                }
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                charRemaining++;
                l++;
            }
        }
        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}
