package java.leetcode.spiralOrder;

import java.util.ArrayList;
import java.util.List;

public class solution {

    // Spiral Matrix
    /*
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // pocetak reda
        int left = 0;
        // za kraj trenutne kolone, desni kraj matrice
        int right = matrix[0].length - 1;
        // pocetak kolone, gornji deo matrice
        int top = 0;
        // za kraj reda, donji deo matrice
        int bottom = matrix.length - 1;
        if (matrix.length == 0) {
            return result;
        }
        while (left <= right && top <= bottom) {
            for (var i = top; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (var i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (var i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (var i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
