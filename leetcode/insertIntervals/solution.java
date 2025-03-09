package java.leetcode.insertIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {

    // insert interval
    /*
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> rez = new ArrayList<>();
        int i = 0;
        int len = intervals.length;
        // Dodaj intervale koji dolaze pre newInterval (bez preklapanja)
        while (i < len && intervals[i][1] < newInterval[0]) {
            rez.add(intervals[i]);
            i++;
        }
        // Spajanje preklapajućih intervala
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[] { Math.min(newInterval[0], intervals[i][0]),
                    Math.max(newInterval[1], intervals[i][1]) };
            i++;
        }
        rez.add(newInterval);
        // dodavanje preostalih intervala
        while (i < len) {
            rez.add(intervals[i]);
            i++;
        }
        return rez.toArray(new int[rez.size()][]);
    }
}
