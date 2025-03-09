package java.leetcode.canConstruct;

import java.util.HashMap;
import java.util.Map;

public class solution {

    // Ransom Note
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (var i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            } else if (map.containsKey(ch) && map.get(ch) == 1) {
                map.remove(ch, map.get(ch));
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return true;
    }

    // drugi nacin
    public static boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char i : ransomNote.toCharArray()) {
            if (!map.containsKey(i) || map.get(i) == 0) {
                return false;
            }
            map.put(i, map.get(i) - 1);
            if (map.get(i) == 0) {
                map.remove(i);
            }
        }
        return true;
    }

    // treci nacin, najbrzi sto se tice memorije, ne koristi hashMap vec
    // predefinisani niz
    public boolean canConstruct3(String ransomNote, String magazine) {
        int[] alpha = new int[26];
        int record;
        for (char ch : ransomNote.toCharArray()) {
            record = magazine.indexOf(ch, alpha[ch - 'a']);
            if (record == -1) {
                return false;
            }
            alpha[ch - 'a'] = 1 + record;
        }
        return true;
    }
}
