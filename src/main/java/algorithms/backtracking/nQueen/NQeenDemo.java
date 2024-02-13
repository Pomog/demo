package algorithms.backtracking.nQueen;

import algorithms.backtracking.ratInMaze.Maze;

public class NQeenDemo {
    public static void main(String[] args) {
        Maze board = new Maze(4, 4);
        
        int columns = board.getXlen();
        
        saveTheQueen(board, 0, columns);
    }
    
    private static void saveTheQueen(Maze board, int col, int columns) {
        //choices
    }
}
