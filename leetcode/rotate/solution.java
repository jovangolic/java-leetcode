package java.leetcode.rotate;

public class solution {

    // rotate image
    /*
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }
        /*
         * int i = 0, j = n - 1;
         * while (i < j) {
         * int[] temp = matrix[i];
         * matrix[i] = matrix[j];
         * matrix[j] = temp;
         * i++;
         * j--;
         * }
         */
        for (var k = 0; k < n; k++) {
            for (var m = k + 1; m < n; m++) {
                int temp = matrix[k][m];
                matrix[k][m] = matrix[m][k];
                matrix[m][k] = temp;
            }
        }
    }
}
