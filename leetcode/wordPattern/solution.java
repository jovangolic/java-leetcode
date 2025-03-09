package java.leetcode.wordPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class solution {

    // word pattern
    /*
     * Input: pattern = "abba", s = "dog cat cat dog"
     * Output: true
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] niz = s.split(" ");
        if (niz.length != pattern.length()) {
            return false;
        }
        Map<String, Integer> wordToChar = new HashMap<>();
        Map<Character, Integer> charToWord = new HashMap<>();
        for (var i = 0; i < pattern.length(); i++) {
            if (wordToChar.containsKey(niz[i]) != charToWord.containsKey(pattern.charAt(i)) ||
                    !Objects.equals(wordToChar.get(niz[i]), (charToWord.get(pattern.charAt(i))))) {
                return false;
            }
            if (!wordToChar.containsKey(niz[i])) {
                wordToChar.put(niz[i], i);
                charToWord.put(pattern.charAt(i), i);
            }
        }
        return true;
    }

    // drugi nacin
    public static boolean wordPattern2(String pattern, String s) {
        String[] niz = s.split(" ");
        if (niz.length != pattern.length()) {
            return false;
        }
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        for (var i = 0; i < pattern.length(); i++) {
            char pat = pattern.charAt(i);
            String str = niz[i];
            if (charToWord.containsKey(pat)) {
                if (!charToWord.get(pat).equals(str)) {
                    return false;
                }
            } else {
                charToWord.put(pat, str);
            }
            if (wordToChar.containsKey(str)) {
                if (wordToChar.get(str) != pat) {
                    return false;
                }
            } else {
                wordToChar.put(str, pat);
            }
        }
        return true;
    }
}
