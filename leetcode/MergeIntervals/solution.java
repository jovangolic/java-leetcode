package java.leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {

    // Merge Intervals
    /*
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][] {};
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> rez = new ArrayList<>();
        int[] niz = intervals[0];
        for (var i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= niz[1]) {
                niz[1] = Math.max(niz[1], interval[1]);
            } else {
                rez.add(niz);
                niz = interval;
            }
        }
        // dodaje ostatak u listu
        rez.add(niz);
        return rez.toArray(new int[rez.size()][]);
    }
}
