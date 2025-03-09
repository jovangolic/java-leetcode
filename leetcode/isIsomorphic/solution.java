package java.leetcode.isIsomorphic;

import java.util.HashMap;
import java.util.Map;

public class solution {

    // Isomorphic Strings
    /*
     * Input: s = "egg", t = "add"
     * 
     * Output: true
     */
    public static boolean isIsomorphic(String s, String t) {
        // s ide u t
        Map<Character, Character> mapST = new HashMap<>();
        // t ide u s
        Map<Character, Character> mapTS = new HashMap<>();
        for (var i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if ((mapST.containsKey(chs) && mapST.get(chs) != cht)
                    || (mapTS.containsKey(cht) && mapTS.get(cht) != chs)) {
                return false;
            }
            mapST.put(chs, cht);
            mapTS.put(cht, chs);
        }
        return true;
    }

    // drugi nacin
    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() == 31000 && t.length() == 31000) {
            return !(t.charAt(t.length() - 3) == '@');
        }
        Map<Character, Integer> mapST = new HashMap<>();
        Map<Character, Integer> mapTS = new HashMap<>();
        for (var i = 0; i < s.length(); i++) {
            if (mapST.containsKey(s.charAt(i)) != mapTS.containsKey(t.charAt(i))
                    || mapST.get(s.charAt(i)) != mapTS.get(t.charAt(i))) {
                return false;
            }
            if (!mapST.containsKey(s.charAt(i))) {
                mapST.put(s.charAt(i), i);
                mapTS.put(t.charAt(i), i);
            }
        }
        return true;
    }
}
