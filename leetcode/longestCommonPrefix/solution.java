package java.leetcode.longestCommonPrefix;

public class solution {

    // strs = ["flower","flow","flight"] otput = "fl"
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Integer minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        for (var i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    // drugi nacin
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return ""; // Ako je niz prazan, vrati ""
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        // Pronađi minimalnu dužinu stringa u nizu
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i); // Uzmi karakter iz prvog stringa
            for (String s : strs) {
                if (s.charAt(i) != c) {
                    return sb.toString(); // Ako postoji neslaganje, vrati dosad pronađeni prefiks
                }
            }
            sb.append(c); // Dodaj karakter samo ako su svi stringovi isti na tom indeksu
        }
        return sb.toString();
    }
}
