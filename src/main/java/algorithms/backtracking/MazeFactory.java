package algorithms.backtracking;

public class MazeFactory {
    
    public Maze getMaze (){
        int[][] matrix = {
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        
        return new Maze(matrix);
    }
}
