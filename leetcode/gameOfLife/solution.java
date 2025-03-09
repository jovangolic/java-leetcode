package java.leetcode.gameOfLife;

public class solution {

    // Game of Life
    /*
     * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
     * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
     */
    public static void gameOfLife(int[][] board) {
        // mapiranje
        // original | new | state
        // 0 | 0 | 0
        // 1 | 0 | 1
        // 0 | 1 | 2
        // 1 | 1 | 3
        if (board == null || board.length == 0)
            return;
        int rows = board.length;
        int cols = board[0].length;
        for (var r = 0; r < rows; r++) {
            for (var c = 0; c < cols; c++) {
                int count = countNeighbours(board, rows, cols, r, c);
                if (board[r][c] == 1 && count >= 2 && count <= 3) {
                    board[r][c] = 3;
                }
                if (board[r][c] == 0 && count == 3) {
                    board[r][c] = 2;
                }
            }
        }
        for (var r = 0; r < rows; r++) {
            for (var c = 0; c < cols; c++) {
                board[r][c] >>= 1;
            }
        }
    }

    private static int countNeighbours(int[][] board, int r, int c, int i, int j) {
        int count = 0;
        for (var x = Math.max(i - 1, 0); x <= Math.min(i + 1, r - 1); x++) {
            for (var y = Math.max(j - 1, 0); y <= Math.min(j + 1, c - 1); y++) {
                count += board[x][y] & 1;
            }
        }
        count -= board[i][j] & 1;
        return count;
    }
}
