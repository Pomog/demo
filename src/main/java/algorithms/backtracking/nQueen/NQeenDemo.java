package algorithms.backtracking.nQueen;

import algorithms.backtracking.ratInMaze.Maze;

public class NQeenDemo {
    static int iteration = 0;
    public static void main(String[] args) {
        Maze board = new Maze(15, 15);
        
        if (saveTheQueens(board, 0)) {
            System.out.println(board.toString());
            System.out.println("Iteration: " + iteration);
        } else {
            System.out.println("No solution");
        }
    }
    
    private static boolean saveTheQueens(Maze board, int col) {
        System.out.println(board.toString());
        iteration++;
        if (col >= board.getXlen()) {
            return true;
        }
        //choices
        for (int row = 0; row < board.getYlen(); row++) {
            // constraints
            if (isSafe(board, row, col)) {
                board.setValueAtPosition(col, row, 1);
                // recursion
                if (saveTheQueens(board, col + 1)) {
                    return true;
                }
                // backtrack
                board.setValueAtPosition(col, row, 0);
            }
        }
        return false;
    }
    
    private static boolean isSafe(Maze board, int row, int col) {
        int i, j;
        
        for (i = 0; i < col; i++) {
            if (board.getValueAtPosition(i, row) == 1) {
                return false;
            }
        }
        
        for (i = row, j = col; i >= 0 && j >= 0; j--, i--) {
            if (board.getValueAtPosition(j, i) == 1) {
                return false;
            }
        }
        
//        for (i = row, j = col; i < board.getYlen() && j < board.getXlen(); j++, i++) {
//            if (board.getValueAtPosition(j, i) == 1) {
//                return false;
//            }
//        }
        
//       for (i = row, j = col; i >= 0 && j < board.getXlen(); j++, i--) {
//            if (board.getValueAtPosition(j, i) == 1) {
//                return false;
//            }
//       }

        for (i = row, j = col; i < board.getYlen() && j >= 0; j--, i++) {
            if (board.getValueAtPosition(j, i) == 1) {
                return false;
            }
        }
        return true;
    }
}
