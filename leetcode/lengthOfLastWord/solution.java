package java.leetcode.lengthOfLastWord;

public class solution {

    // Length of Last Word: s = "Hello World"
    public static int lengthOfLastWord(String s) {
        int len = 0;
        // uklanja visestruke razmake iz stringa i svodi ih na jedan razmak
        String clean = s.trim().replaceAll("\\s+", " ");
        String[] niz = clean.split(" ");
        String str = niz[niz.length - 1];
        len = str.length();
        return len;
    }

    // drugi nacin
    public static int lengthOfLastWord2(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int end = i;
        while (end >= 0 && s.charAt(end) != ' ') {
            end--;
        }
        return i - end;
    }
}
