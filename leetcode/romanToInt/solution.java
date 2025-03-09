package java.leetcode.romanToInt;

import java.util.HashMap;
import java.util.Map;

public class solution {

    // from roman to int
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int acc = 0;
        for (var i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                acc -= map.get(s.charAt(i));
            } else {
                acc += map.get(s.charAt(i));
            }
        }
        return acc;
    }

    // roman to int
    public static int romanToInt3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for (var i = 0; i < s.length(); i++) {
            // moze i ovaj edge case i < s.length() - 1
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

    // drugi nacin koriscenjem while petlje
    public static int romanToInteger(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (i < n - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i += 2;
            } else {
                res += map.get(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
