package java.leetcode.setZeroes;

public class solution {

    // Set Matrix Zeroes. Optimalno resenje, jer je prostorna slozenost O(1).Koristi
    // prvi red i prvu kolonu kao memoriju
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // ako je prvi red nula
        boolean rowZero = false;
        // odredjivanje koje rows/cols treba da budu nule
        for (var r = 0; r < rows; r++) {
            for (var c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    if (r > 0) {
                        matrix[r][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }
        for (var r = 1; r < rows; r++) {
            for (var c = 1; c < cols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        // prvi red;
        if (matrix[0][0] == 0) {
            for (var r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
        // prva kolona
        if (rowZero == true) {
            for (var c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }
    }

    // drugi nacin, nije optimalno resenje
    public static void setZeroes2(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] row = new int[r];
        int[] col = new int[c];
        for (var i = 0; i < r; i++) {
            for (var j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (var i = 0; i < r; i++) {
            for (var j = 0; j < c; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
