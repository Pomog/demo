/**
 * This class demonstrates the Knight's Tour problem using backtracking.
 */
package algorithms.backtracking.knights;

import algorithms.backtracking.maze.Maze;

public class KnightsDemo {
    static int iteration = 0;
    private static final int BOARD_SIZE = 8;
    private static final int MAX_MOVES = (BOARD_SIZE * BOARD_SIZE) - 1;
    private static final int[] rowMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public static void main(String[] args) {
        Maze board = new Maze(BOARD_SIZE, BOARD_SIZE);
        knightTour(board, 0, 0, 0);
    }
    
    /**
     * Recursive method to find the Knight's Tour.
     *
     * @param board  The maze board.
     * @param row    The current row position of the knight.
     * @param column The current column position of the knight.
     * @param step   The current step number of the knight's tour.
     * @return True if a tour is found, otherwise false.
     */
    private static boolean knightTour(Maze board, int row, int column, int step) {
        iteration++;
        if (step == MAX_MOVES) {
            System.out.println(board);
            System.out.printf("Number of iteration is: %d%n", iteration);
            return true;
        }
        
        for (int i = 0; i < board.getXlen(); i++) {
            int newRow = row + rowMoves[i];
            int newColumn = column + colMoves[i];
            
            if (isValidMove(board, newRow, newColumn)) {
                step++;
                board.setValueAtPosition(newColumn, newRow, step);
                
                if (knightTour(board, newRow, newColumn, step)) {
                    return true;
                }
                
                step--;
                board.setValueAtPosition(newColumn, newRow, 0);
            }
        }
        return false;
    }
    
    /**
     * Checks if the knight move to the new position is valid.
     *
     * @param board     The maze board.
     * @param newRow    The new row position.
     * @param newColumn The new column position.
     * @return True if the move is valid, otherwise false.
     */
    private static boolean isValidMove(Maze board, int newRow, int newColumn) {
        return (newRow >= 0 && newRow < BOARD_SIZE) &&
                (newColumn >= 0 && newColumn < BOARD_SIZE) &&
                board.getValueAtPosition(newColumn, newRow) == 0;
    }
}
