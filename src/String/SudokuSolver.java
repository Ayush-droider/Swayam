package String;

import java.util.*;
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        List<int[]> empties = new ArrayList<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    empties.add(new int[]{r, c});
                } else {
                    int val = board[r][c] - '1';
                    rows[r][val] = true;
                    cols[c][val] = true;
                    boxes[(r / 3) * 3 + c / 3][val] = true;
                }
            }
        }
        backtrack(board, 0, empties, rows, cols, boxes);
    }
    private boolean backtrack(char[][] board, int idx, List<int[]> empties, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        if (idx == empties.size()) return true;
        int r = empties.get(idx)[0];
        int c = empties.get(idx)[1];
        int b = (r / 3) * 3 + c / 3;
        for (int d = 0; d < 9; d++) {
            if (!rows[r][d] && !cols[c][d] && !boxes[b][d]) {
                board[r][c] = (char) ('1' + d);
                rows[r][d] = cols[c][d] = boxes[b][d] = true;
                if (backtrack(board, idx + 1, empties, rows, cols, boxes)) return true;
                rows[r][d] = cols[c][d] = boxes[b][d] = false;
                board[r][c] = '.';
            }
        }
        return false;
    }
}

