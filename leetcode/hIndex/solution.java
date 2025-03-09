package java.leetcode.hIndex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class solution {

    public static int hIndex(int[] niz) {
        int papers = niz.length;
        int[] buckets = new int[papers + 1];
        for (var i : niz) {
            buckets[Math.min(i, papers)]++;
        }
        int total = 0;
        for (var i = papers; i >= 0; i--) {
            total += buckets[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }

    // drugi nacin, sa recnikom
    public static int hIndex2(int[] niz) {
        int n = niz.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : niz) {
            map.put(Math.min(i, n), map.getOrDefault(Math.min(i, n), 0) + 1);
        }
        int total = 0;
        for (var i = n; i >= 0; i--) {
            total += map.getOrDefault(i, 0);
            if (total >= i) {
                return i;
            }
        }
        return total;
    }

    // treci nacin, sortiranjem
    public static int hIndex3(int[] niz) {
        int n = niz.length;
        Arrays.sort(niz);
        for (var i = 0; i < n; i++) {
            if (niz[i] >= n - 1) {
                return n - 1;
            }
        }
        return 0;
    }
}
