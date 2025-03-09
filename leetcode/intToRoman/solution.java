package java.leetcode.intToRoman;

import java.util.LinkedHashMap;
import java.util.Map;

public class solution {

    public static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (var i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }

    // drugi nacin
    public static String integerToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        StringBuilder sb = new StringBuilder();
        // ovaj entrySet() vraca skup koji sadrzi kljuc/vrednost par. Ako zelimo kljuc
        // koristimo getKey(),a
        // ako zelimo vrednost koristimo getValue()
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (num >= entry.getKey()) {
                sb.append(entry.getValue());
                num -= entry.getKey();
                if (num == 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
