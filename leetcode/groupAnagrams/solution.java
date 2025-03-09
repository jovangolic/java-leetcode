package java.leetcode.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class solution {

    // Group Anagrams
    /*
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Koristimo HashMap sa ključem koji je niz od 26 brojeva (frekvencija slova)
        Map<String, List<String>> map = new HashMap<>();
        for (String i : strs) {
            // Kreiramo niz koji sadrži broj pojavljivanja svakog slova
            int[] alpha = new int[26];
            for (char c : i.toCharArray()) {
                alpha[c - 'a']++; // Povećavamo broj pojavljivanja karaktera
            }
            // Kreiramo ključ koji je reprezentacija niza kao string
            StringBuilder sb = new StringBuilder();
            for (int count : alpha) {
                sb.append(count).append("#"); // Koristimo '#' kao separator između brojeva
            }
            // Ako ključ nije u mapi, dodajemo novu listu
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            // Dodajemo trenutni string u odgovarajuću grupu
            map.get(sb.toString()).add(i);
        }
        // Na kraju, vraćamo listu svih grupa
        return new ArrayList<>(map.values());
    }

    // drugi nacin
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sb = new String(c);
            if (!map.containsKey(sb)) {
                map.put(sb, new ArrayList<>());
            }
            map.get(sb).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
