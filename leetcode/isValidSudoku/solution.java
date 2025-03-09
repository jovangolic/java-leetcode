package java.leetcode.isValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class solution {

    // valid sudoku
    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') { // Ako nije prazno polje
                    if (!set.add("row_" + i + "_" + num) || // Provera reda
                            !set.add("col_" + j + "_" + num) || // Provera kolone
                            !set.add("box_" + (i / 3) + "_" + (j / 3) + "_" + num)) { // Provera 3x3 bloka
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // valid sudoku drugi nacin. Ima brze vreme izvrsavanja
    public static boolean isValidSudoku2(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] subBoxes = new HashSet[9];
        for (var i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            subBoxes[i] = new HashSet<>();
        }
        for (var r = 0; r < 9; r++) {
            for (var c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                char num = board[r][c];
                int index = (r / 3) * 3 + (c / 3);
                if (rows[r].contains(num) || cols[c].contains(num) || subBoxes[index].contains(num)) {
                    return false;
                }
                rows[r].add(num);
                cols[c].add(num);
                subBoxes[index].add(num);
            }
        }
        return true;
    }

    // treci nacin
    public boolean isValidSudoku3(char[][] board) {
        return dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col) {
        if (row == 9)
            return true; // If all rows are checked, return true
        if (col == 9)
            return dfs(board, row + 1, 0); // Move to next row
        if (board[row][col] != '.') { // If cell is not empty, validate and continue
            if (!isValid(board, row, col))
                return false;
            return dfs(board, row, col + 1);
        }
        return dfs(board, row, col + 1); // Continue traversal for empty cells
    }

    private boolean isValid(char[][] board, int row, int col) {
        char num = board[row][col];
        // Check row
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == num)
                return false;
        }
        // Check column
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == num)
                return false;
        }
        // Check 3x3 sub-box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if ((i != row || j != col) && board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}
