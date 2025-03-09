package java.leetcode.convert;

public class solution {

    // zigzag conversation
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (var i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int i = 0;
        int direction = 1;
        for (var c = 0; c < s.length(); c++) {
            sbs[i].append(s.charAt(c));
            if (i == 0) {
                direction = 1;
            } else if (i == numRows - 1) {
                direction = -1;
            }
            i += direction;
        }
        StringBuilder sb = new StringBuilder();
        for (var j = 0; j < numRows; j++) {
            sb.append(sbs[j]);
        }
        return sb.toString();
    }

    // drugi nacin
    public static String zigzag(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (var i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        // definisanje promenljivih;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;
        // traverse zig-zag
        while (index < n) {
            // idi dole
            for (var j = 0; j < numRows && index < n; j++) {
                sbs[j].append(arr[index++]);
            }
            // idi gore pre starta
            for (var j = numRows - 2; j > 0 && index < n; j--) {
                sbs[j].append(arr[index++]);
            }
        }
        StringBuilder res = sbs[0];
        for (var i = 1; i < numRows; i++) {
            res.append(sbs[i]).toString();
        }
        return res.toString();
    }
}
