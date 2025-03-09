package java.leetcode.isPalindrome;

public class solution {

    // Valid Palindrome
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        String str = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
