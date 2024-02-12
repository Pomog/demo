package algorithms.backtracking;

/*
Objects: maze as matrix with 1 and 0 cells, 1 - allowed, 0 - not allowed: The Rat in a maze - abstraction.
Choices: move in X direction or move in Y direction.
Constraints: The Rat can move only into cell with 1, inside the maze.
Recursion: go to X direction or go to Y direction.
Backtracking: if there is no ways from the cell - mark it as 0.
Goal: The Rat reaches cell X=N-1 and Y=N-1, right left conner.
 */

import lombok.Getter;

/**
 * Represents a solver for the Rat in a Maze problem using backtracking algorithm.
 * The maze consists of cells with values 0 or 1, where 1 represents an allowed path and
 * 0 represents a blocked path.
 * The rat can only move into cells with value 1.
 */

public class RatInMaze {
    Maze maze;
    int Xlen;
    int Ylen;
    
    /** The solution maze representing the path taken by the rat to reach the destination. */
    @Getter
    Maze solMaze;
    
    /**
     * Constructs a RatInMaze solver with the given maze.
     * @param maze The maze to be solved.
     */
    public RatInMaze(Maze maze) {
        this.maze = maze;
        this.Xlen = maze.getXlen();
        this.Ylen = maze.getYlen();
        this.solMaze = new Maze(Xlen, Ylen);
    }
    
    /**
     * Calculates the path for the rat starting from the specified position.
     * @param startX The starting X-coordinate of the rat.
     * @param startY The starting Y-coordinate of the rat.
     */
    public void calculatePath(int StartX, int StartY) {
        solveTheMaze(maze, StartX, StartY, solMaze);
    }
    
    /**
     * Recursively solves the maze using backtracking algorithm.
     * @param maze The maze to be solved.
     * @param posX The current X-coordinate of the rat.
     * @param posY The current Y-coordinate of the rat.
     * @param emptyMaze The empty maze representing the solution path.
     * @return True if a path to the destination is found, otherwise false.
     */
    public boolean solveTheMaze(Maze maze, int posX, int posY, Maze emptyMaze) {
        if (posX == maze.getXlen() - 1 && posY == maze.getYlen() - 1 && maze.getValueAtPosition(posX, posY) == 1) {
            solMaze.setValueAtPosition(posX, posY, 1);
            return true;
        }

        if (isSafe(maze, posX, posY)) {
            solMaze.setValueAtPosition(posX, posY, 1);
            
            if (solveTheMaze(maze, posX + 1, posY, solMaze)) {
                return true;
            }
            if (solveTheMaze(maze, posX, posY + 1, solMaze)) {
                return true;
            }
            
            solMaze.setValueAtPosition(posX, posY, 0);
            return false;
        }
        return false;
    }
    
    /**
     * Checks if the given position is safe to move into.
     * @param maze The maze to be checked.
     * @param posX The X-coordinate of the position to be checked.
     * @param posY The Y-coordinate of the position to be checked.
     * @return True if the position is safe to move into, otherwise false.
     */
    private boolean isSafe(Maze maze, int posX, int posY) {
        return (
                posX >= 0 && posX < maze.getXlen()
                &&
                posY >= 0 && posY < maze.getYlen()
                &&
                maze.getValueAtPosition(posX, posY) == 1
        );
    }
    
}
