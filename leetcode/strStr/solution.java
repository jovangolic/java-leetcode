package java.leetcode.strStr;

public class solution {

    // Find the Index of the First Occurrence in a String
    // sadbutsad sad
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        for (var i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            for (var j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
