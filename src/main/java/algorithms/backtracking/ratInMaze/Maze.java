package algorithms.backtracking.ratInMaze;

public class Maze {
    int[][] maze;
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            for (int cell : row) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public Maze(int[][] maze) {
        this.maze = maze;
    }
    public Maze(int x, int y) {
        this.maze = new int[y][x]; // ORDER!, [rows][columns]
    }
    
    public int getYlen(){
        return maze.length;
    }
    public int getXlen(){
        return maze[0].length;
    }
    
    public int getValueAtPosition(int column, int row) {
        return maze[row][column];
    }
    
    public void setValueAtPosition(int column, int row, int value) {
        maze[row][column] = value;
    }
}
