package com.sudoku.solver.service;
public class SudokuSolver {

    public boolean solveSudoku(int[][] board) {
        int N = board.length;
        
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            
                            if (solveSudoku(board)) {
                                return true;
                            }
                            
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // All cells are filled
    }
    
    private boolean isValid(int[][] board, int row, int col, int num) {
        int N = board.length;
        
        // Check row and column
        for (int i = 0; i < N; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        
 
        int subgridStartRow = row - row % 3;
        int subgridStartCol = col - col % 3;
        for (int i = subgridStartRow; i < subgridStartRow + 3; i++) {
            for (int j = subgridStartCol; j < subgridStartCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
