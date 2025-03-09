package java.leetcode.reverseWords;

public class solution {

    // Input: s = " hello world "
    // Output: "world hello"
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] niz = s.trim().replaceAll("\\s+", " ").split(" ");
        for (var str = niz.length - 1; str >= 0; str--) {
            sb.append(niz[str]).append(" ");
        }
        return sb.toString().trim();
    }
}
