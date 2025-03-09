package java.leetcode.findMinArrowShots;

import java.util.Arrays;

public class solution {

    // Minimum Number of Arrows to Burst Balloons
    /*
     * Input: points = [[10,16],[2,8],[1,6],[7,12]]
     * Output: 2
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        // broj strela
        int rez = points.length;
        int[] niz = points[0];
        for (var i = 1; i < points.length; i++) {
            int[] point = points[i];
            // da li se preklapaju
            if (point[0] <= niz[1]) {
                // ako se preklapaju, oba mogu biti unistena sa jednom strelom
                rez--;
                niz = new int[] { point[0], Math.min(point[1], niz[1]) };
            } else {
                niz = point;
            }
        }
        return rez;
    }

    // drugi nacin
    public static int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int rez = 1;
        int max = points[0][1];
        for (var i = 1; i < points.length; i++) {
            if (points[i][0] > max) {
                max = points[i][1];
                rez++;
            }
        }
        return rez;
    }
}
