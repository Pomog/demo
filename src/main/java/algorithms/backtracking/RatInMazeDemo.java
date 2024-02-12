package algorithms.backtracking;

public class RatInMazeDemo {
    public static void main(String[] args) {
        Maze maze = new MazeFactory().getMaze();
        System.out.println(maze);
        
        RatInMaze ratInMaze = new RatInMaze(maze);
        ratInMaze.calculatePath(0,2);
        
        System.out.println(ratInMaze.getSolMaze());
    }
}
