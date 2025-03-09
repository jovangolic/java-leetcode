package java.leetcode.isSubsequence2;

public class solution {

    // isSubsequence
    // s = "abc", t = "ahbgdc"
    public static boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
