package java.leetcode.isAnagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class solution {

    // Valid Anagram
    /*
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (var i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            if (mapS.containsKey(entry.getKey()) != mapT.containsKey(entry.getKey())
                    || !Objects.equals(mapS.get(entry.getKey()), mapT.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    // drugi nacin
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphaS = new int[26];
        int[] alphaT = new int[26];
        for (var i = 0; i < s.length(); i++) {
            alphaS[s.charAt(i) - 'a']++;
            alphaT[t.charAt(i) - 'a']++;
        }
        // Poređenje frekvencijskih nizova. Ovaj broj 26, predstavlja slova u engleskoj
        // azbuci
        for (var i = 0; i < 26; i++) {
            if (alphaS[i] != alphaT[i]) {
                return false;
            }
        }
        return true;
    }

    // treci nacin
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] niz = new int[26];
        for (char c : s.toCharArray()) {
            niz[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            niz[c - 'a']--;
        }
        for (var i = 0; i < 26; i++) {
            if (niz[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
